package com.fireitup.grillhub.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MealDTO {
  private String name;
  private String description;
  private MeatDTO meat;
  private RubDTO rub;
  private UserDTO createdByUser;
  private String createdAt;
}
