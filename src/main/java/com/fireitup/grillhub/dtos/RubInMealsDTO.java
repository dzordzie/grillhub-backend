package com.fireitup.grillhub.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RubInMealsDTO {
  private String name;
  private UserDTO createdByUser;
  private Set<MealNameAndIdDTO> meals;
}
