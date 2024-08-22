package com.fireitup.grillhub.controllers;

import com.fireitup.grillhub.dtos.ErrorMessageDTO;
import com.fireitup.grillhub.dtos.MealToPostDTO;
import com.fireitup.grillhub.dtos.NewMealDTO;
import com.fireitup.grillhub.dtos.SuccessMessageDTO;
import com.fireitup.grillhub.entities.User;
import com.fireitup.grillhub.exceptions.MealNotFoundException;
import com.fireitup.grillhub.services.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

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
  public ResponseEntity<?> getMeal(@PathVariable Long id) {
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

  @PostMapping("/add-new")
  public ResponseEntity<?> addNewMeal(@RequestBody NewMealDTO newMealDTO, @AuthenticationPrincipal User user) {
    if (newMealDTO == null) {
      ErrorMessageDTO errorMsg = new ErrorMessageDTO("Input data are not valid");
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMsg.getMessage());
    }
    try {
      mealService.addMeal(newMealDTO, user);
      SuccessMessageDTO successMsg = new SuccessMessageDTO("Meal added successfully!");
      return ResponseEntity.status(HttpStatus.CREATED).body(successMsg);
    } catch (IllegalArgumentException e) {
      ErrorMessageDTO errorMsg = new ErrorMessageDTO(e.getMessage());
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMsg);
    } catch (Exception e) {
      ErrorMessageDTO errorMsg = new ErrorMessageDTO("An unexpected error occurred.");
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMsg);
    }
  }

}
