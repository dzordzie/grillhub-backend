package com.fireitup.grillhub.dtos;

import com.fireitup.grillhub.enums.MeatType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeatDTO {
  private String typeOfCut;
  private Integer weightInGrams;
  private Integer internalTemp;
  private Integer ambientTemp;
  private String meatType;
}
