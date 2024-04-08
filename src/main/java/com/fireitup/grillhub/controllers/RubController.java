package com.fireitup.grillhub.controllers;

import com.fireitup.grillhub.dtos.MealDTO;
import com.fireitup.grillhub.dtos.RubDTO;
import com.fireitup.grillhub.entities.Rub;
import com.fireitup.grillhub.repositories.RubRepository;
import com.fireitup.grillhub.services.RubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rubs")
public class RubController {

  private final RubService rubService;
  private final RubRepository rubRepository;

  @GetMapping("")
  public ResponseEntity<List<Rub>> getRubs() {
    return ResponseEntity.ok().body(rubRepository.findAllRubs());
  }
}
