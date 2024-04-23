package com.fireitup.grillhub.services;

import com.fireitup.grillhub.dtos.MealDTO;
import com.fireitup.grillhub.dtos.MealToPostDTO;
import com.fireitup.grillhub.entities.Meal;
import com.fireitup.grillhub.exceptions.MealNotFoundException;
import com.fireitup.grillhub.repositories.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MealServiceImpl implements MealService {

  private final MealRepository mealRepository;
  private final DTOConvertService dtoConvertService;

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
}
