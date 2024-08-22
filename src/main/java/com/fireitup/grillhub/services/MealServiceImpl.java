package com.fireitup.grillhub.services;

import com.fireitup.grillhub.dtos.MealDTO;
import com.fireitup.grillhub.dtos.MealToPostDTO;
import com.fireitup.grillhub.dtos.NewMealDTO;
import com.fireitup.grillhub.dtos.SpiceDTO;
import com.fireitup.grillhub.entities.*;
import com.fireitup.grillhub.enums.MeatType;
import com.fireitup.grillhub.exceptions.MealNotFoundException;
import com.fireitup.grillhub.repositories.MealRepository;
import com.fireitup.grillhub.repositories.MeatRepository;
import com.fireitup.grillhub.repositories.RubRepository;
import com.fireitup.grillhub.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MealServiceImpl implements MealService {

  private final MealRepository mealRepository;
  private final MeatRepository meatRepository;
  private final RubRepository rubRepository;
  private final UserRepository userRepository;
  private final DTOConvertService dtoConvertService;
  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<MealToPostDTO> getAllMeals() {
    List<Meal> allMeals = mealRepository.findAllMeals();
    List<MealToPostDTO> allMealsDTO = new ArrayList<>();
    for (Meal meal : allMeals) {
      allMealsDTO.add(dtoConvertService.mealToPostToDTO(meal));
    }
    return allMealsDTO;
  }

  @Override
  public MealDTO getMealById(Long id) {
    return mealRepository.findMealById(id)
        .map(dtoConvertService::mealToDTO)
        .orElseThrow(() -> new MealNotFoundException(id));
  }

  @Override
  @Transactional
  public void addMeal(NewMealDTO newMealDTO, @AuthenticationPrincipal User user) {
    user = entityManager.merge(user);

    Meal meal = new Meal();
    meal.setName(newMealDTO.getName());
    meal.setDescription(newMealDTO.getDescription());
    meal.setImageBase64(newMealDTO.getImageBase64());
    meal.setCreatedBy(user);

    if (newMealDTO.getMeat() != null) {
      Meat meat = Meat.builder()
          .typeOfCut(newMealDTO.getMeat().getTypeOfCut())
          .weightInGrams(newMealDTO.getMeat().getWeightInGrams())
          .internalTemp(newMealDTO.getMeat().getInternalTemp())
          .ambientTemp(newMealDTO.getMeat().getAmbientTemp())
          .meatType(MeatType.valueOf(newMealDTO.getMeat().getMeatType()))
          .build();
      meatRepository.save(meat);
      meal.setMeat(meat);
    }

    if (newMealDTO.getRub() != null) {
      Rub rub;
      if (newMealDTO.getRub().getId() != null) {
        rub = rubRepository.findRubById(newMealDTO.getRub().getId())
            .orElseThrow(() -> new IllegalArgumentException("Invalid rub ID"));
      } else {
        rub = new Rub();
      }
      rub.setName(newMealDTO.getRub().getName());
      rub.setCreatedBy(user);

      Set<Spice> spices = new HashSet<>();
      for (SpiceDTO spiceDTO : newMealDTO.getRub().getSpices()) {
        Spice spice = new Spice();
        spice.setName(spiceDTO.getName());
        spice.setWeightInGrams(spiceDTO.getWeightInGrams());
        spices.add(spice);
      }

      rub.setSpices(spices);
      rubRepository.save(rub);
      meal.setRub(rub);
    }

    mealRepository.save(meal);
  }
}
