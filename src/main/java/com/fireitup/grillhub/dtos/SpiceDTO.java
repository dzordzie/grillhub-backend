package com.fireitup.grillhub.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpiceDTO {
  private Long id;
  private String name;
  private RubDTO rubDTO;
}