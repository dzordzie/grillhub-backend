package com.fireitup.grillhub.controllers;

import com.fireitup.grillhub.dtos.ErrorMessageDTO;
import com.fireitup.grillhub.dtos.MealToPostDTO;
import com.fireitup.grillhub.exceptions.MealNotFoundException;
import com.fireitup.grillhub.services.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MealController {

  private final MealService mealService;

  @GetMapping("/")
  public ResponseEntity<List<MealToPostDTO>> getMeals() {
    return ResponseEntity.ok().body(mealService.getAllMeals());
  }

  @GetMapping("/meal/{id}")
  public ResponseEntity getMeal(@PathVariable Long id) {
    if (id == null) {
      ErrorMessageDTO errorMsg = new ErrorMessageDTO("Input data are not valid");
      return ResponseEntity.status(400).body(errorMsg);
    }
    try {
      return ResponseEntity.ok().body(mealService.getMealById(id));
    } catch (MealNotFoundException e) {
      ErrorMessageDTO errorMsg = new ErrorMessageDTO("This meal doesn't exist!");
      return ResponseEntity.status(404).body(errorMsg);
    }
  }

}
