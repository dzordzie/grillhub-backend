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
public class UserPostsDTO {
  private String username;
  private Set<MealNameAndIdDTO> meals;
  private Set<RubNameAndIdDTO> rubs;
}
