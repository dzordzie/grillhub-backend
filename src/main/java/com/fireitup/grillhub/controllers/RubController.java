package com.fireitup.grillhub.controllers;

import com.fireitup.grillhub.dtos.ErrorMessageDTO;
import com.fireitup.grillhub.exceptions.RubNotFoundException;
import com.fireitup.grillhub.services.RubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RubController {

  private final RubService rubService;

  @GetMapping("/rub/{id}")
  public ResponseEntity getRubInMeals(@PathVariable Long id) {
    if (id == null) {
      ErrorMessageDTO errorMsg = new ErrorMessageDTO("Input data are not valid");
      return ResponseEntity.status(400).body(errorMsg);
    }
    try {
      return ResponseEntity.ok().body(rubService.getRubInMealsById(id));
    } catch (RubNotFoundException e) {
      ErrorMessageDTO errorMsg = new ErrorMessageDTO("This rub doesn't exist!");
      return ResponseEntity.status(404).body(errorMsg);
    }
  }

}
