package com.fireitup.grillhub.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MealNotFoundException extends RuntimeException {

  private final Long mealId;

  public MealNotFoundException(Long mealId) {
    super("Meal with ID " + mealId + " doesn't exist");
    this.mealId = mealId;
  }

}
