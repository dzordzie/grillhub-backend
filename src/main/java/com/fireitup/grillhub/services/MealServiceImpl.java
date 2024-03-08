package com.fireitup.grillhub.services;

import com.fireitup.grillhub.dtos.MealDTO;
import com.fireitup.grillhub.entities.Meal;
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
  public List<MealDTO> getAllMeals() {
    List<Meal> allMeals = mealRepository.findAllMeals();
    List<MealDTO> allMealsDTO = new ArrayList<>();
    for (Meal meal : allMeals) {
      allMealsDTO.add(dtoConvertService.mealToDTO(meal));
    }
    return allMealsDTO;
  }
}
