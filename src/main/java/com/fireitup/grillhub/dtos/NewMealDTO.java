package com.fireitup.grillhub.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewMealDTO {
  private String name;
  private String description;
  private String imageBase64;
  private MeatDTO meat;
  private RubDTO rub;

}