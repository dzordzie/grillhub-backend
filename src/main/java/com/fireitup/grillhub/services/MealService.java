package com.fireitup.grillhub.services;

import com.fireitup.grillhub.dtos.MealDTO;
import com.fireitup.grillhub.dtos.MealToPostDTO;

import java.util.List;

public interface MealService {

  List<MealToPostDTO> getAllMeals();

  MealDTO getMealById(Long id);

}
