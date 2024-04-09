package com.fireitup.grillhub.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MealToPostDTO {
  private Long id;
  private String name;
  private String description;
  private String meatType;
  private UserDTO createdByUser;
  private String createdAt;
}
