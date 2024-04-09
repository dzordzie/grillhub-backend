package com.fireitup.grillhub.controllers;

import com.fireitup.grillhub.dtos.MealToPostDTO;
import com.fireitup.grillhub.services.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

}
