package com.fireitup.grillhub.services;

import com.fireitup.grillhub.repositories.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MealServiceImpl implements MealService {

  private final MealRepository mealRepository;

}
