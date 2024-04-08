package com.fireitup.grillhub.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MealDTO {
  private Long id;
  private String name;
  private String description;
  private MeatDTO meatDTO;
  private RubDTO rubDTO;
  private UserDTO createdByUser;
  private String createdAt;
}
