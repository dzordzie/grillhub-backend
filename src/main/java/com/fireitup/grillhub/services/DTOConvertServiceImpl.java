package com.fireitup.grillhub.services;

import com.fireitup.grillhub.dtos.*;
import com.fireitup.grillhub.entities.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DTOConvertServiceImpl implements DTOConvertService {

  public UserDTO userToDTO(User user) {
    if (user == null) {
      throw new IllegalArgumentException("User cannot be null");
    }
    return UserDTO.builder()
        .id(user.getId())
        .username(user.getUsername())
        .build();
  }


  public RubDTO rubToDTO(Rub rub) {
    if (rub == null) {
      throw new IllegalArgumentException("Rub cannot be null");
    }
    return RubDTO.builder()
        .id(rub.getId())
        .name(rub.getName())
        .createdByUser(userToDTO(rub.getCreatedBy()))
        .build();
  }


  public MeatDTO meatToDTO(Meat meat) {
    if (meat == null) {
      throw new IllegalArgumentException("Meat cannot be null");
    }
    return MeatDTO.builder()
        .id(meat.getId())
        .typeOfCut(meat.getTypeOfCut())
        .weightInGrams(meat.getWeightInGrams())
        .internalTemp(meat.getInternalTemp())
        .ambientTemp(meat.getAmbientTemp())
        .meatType(meat.getMeatType())
        .build();
  }


  public SpiceDTO spiceToDTO(Spice spice) {
    if (spice == null) {
      throw new IllegalArgumentException("Spice cannot be null");
    }
    return SpiceDTO.builder()
        .id(spice.getId())
        .name(spice.getName())
        .rubDTO(rubToDTO(spice.getRub()))
        .build();
  }


  public MealDTO mealToDTO(Meal meal) {
    if (meal == null) {
      throw new IllegalArgumentException("Meal cannot be null");
    }
    return MealDTO.builder()
        .id(meal.getId())
        .name(meal.getName())
        .description(meal.getDescription())
        .meatDTO(meatToDTO(meal.getMeat()))
        .rubDTO(rubToDTO(meal.getRub()))
        .createdByUser(userToDTO(meal.getCreatedBy()))
        .createdAt(meal.getCreatedAt())
        .build();
  }


}
