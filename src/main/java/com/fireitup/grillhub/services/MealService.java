package com.fireitup.grillhub.services;

import com.fireitup.grillhub.dtos.MealDTO;
import com.fireitup.grillhub.dtos.MealToPostDTO;
import com.fireitup.grillhub.dtos.NewMealDTO;
import com.fireitup.grillhub.entities.Meat;
import com.fireitup.grillhub.entities.Rub;
import com.fireitup.grillhub.entities.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.util.List;

public interface MealService {

  List<MealToPostDTO> getAllMeals();

  MealDTO getMealById(Long id);

  void addMeal(NewMealDTO newMealDTO, @AuthenticationPrincipal User user);
}
