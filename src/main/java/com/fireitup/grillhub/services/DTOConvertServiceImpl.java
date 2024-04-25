package com.fireitup.grillhub.services;

import com.fireitup.grillhub.dtos.*;
import com.fireitup.grillhub.entities.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

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

  @Override
  public UserProfileDTO userToUserProfileDTO(User user) {
    if (user == null) {
      throw new IllegalArgumentException("User cannot be null");
    }
    return UserProfileDTO.builder()
        .email(user.getEmail())
        .userPosts(userToUserPostsDTO(user))
        .build();
  }

  @Override
  public UserPostsDTO userToUserPostsDTO(User user) {
    if (user == null) {
      throw new IllegalArgumentException("User cannot be null");
    }
    return UserPostsDTO.builder()
        .username(user.getUsername())
        .rubs(setOfRubNameAndIdToDTO(user.getRubs()))
        .meals(setOfMealNameAndIdToDTO(user.getMeals()))
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
        .spices(spiceSetToDTO(rub.getSpices()))
        .build();
  }

  @Override
  public RubNameAndIdDTO rubToNameAndIdDTO(Rub rub) {
    if (rub == null) {
      throw new IllegalArgumentException("Rub cannot be null");
    }
    return RubNameAndIdDTO.builder()
        .id(rub.getId())
        .name(rub.getName())
        .build();
  }

  @Override
  public RubInMealsDTO rubInMealsToDTO(Rub rub) {
    if (rub == null) {
      throw new IllegalArgumentException("Rub cannot be null");
    }
    return RubInMealsDTO.builder()
        .name(rub.getName())
        .createdByUser(userToDTO(rub.getCreatedBy()))
        .spices(spiceSetToDTO(rub.getSpices()))
        .meals(setOfMealNameIdUserToDTO(rub.getMeals()))
        .build();
  }

  public Set<RubNameAndIdDTO> setOfRubNameAndIdToDTO(Set<Rub> rubs) {
    Set<RubNameAndIdDTO> rubNameAndIdDTO = new HashSet<>();
    for (Rub rub : rubs) {
      rubNameAndIdDTO.add(this.rubToNameAndIdDTO(rub));
    }
    return rubNameAndIdDTO;
  }


  public MeatDTO meatToDTO(Meat meat) {
    if (meat == null) {
      throw new IllegalArgumentException("Meat cannot be null");
    }
    return MeatDTO.builder()
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
        .name(spice.getName())
        .weightInGrams(spice.getWeightInGrams())
        .build();
  }


  public Set<SpiceDTO> spiceSetToDTO(Set<Spice> spices) {
    if (spices.isEmpty()) {
      throw new IllegalArgumentException("Spices cannot be empty");
    }
    Set<SpiceDTO> spicesDTO = new HashSet<>();
    for (Spice spice : spices) {
      spicesDTO.add(spiceToDTO(spice));
    }
    return spicesDTO;
  }

  public Set<MealNameAndIdDTO> setOfMealNameAndIdToDTO(Set<Meal> meals) {
    Set<MealNameAndIdDTO> mealNameAndIdDTO = new HashSet<>();
    for (Meal meal : meals) {
      mealNameAndIdDTO.add(this.mealToNameAndIdDTO(meal));
    }
    return mealNameAndIdDTO;
  }

  public Set<MealNameIdUserDTO> setOfMealNameIdUserToDTO(Set<Meal> meals) {
    if (meals.isEmpty()) {
      throw new IllegalArgumentException("Meals cannot be empty");
    }
    Set<MealNameIdUserDTO> mealNameIdUserDTO = new HashSet<>();
    for (Meal meal : meals) {
      mealNameIdUserDTO.add(this.mealNameAndIdToDTO(meal));
    }
    return mealNameIdUserDTO;
  }


  public MealToPostDTO mealToPostToDTO(Meal meal) {
    if (meal == null) {
      throw new IllegalArgumentException("Meal cannot be null");
    }
    return MealToPostDTO.builder()
        .id(meal.getId())
        .name(meal.getName())
        .description(meal.getDescription())
        .meatType(meatToDTO(meal.getMeat()).getMeatType().toString())
        .createdByUser(userToDTO(meal.getCreatedBy()))
        .createdAt(meal.getFormattedCreatedAt())
        .build();
  }

  @Override
  public MealDTO mealToDTO(Meal meal) {
    if (meal == null) {
      throw new IllegalArgumentException("Meal cannot be null");
    }
    return MealDTO.builder()
        .name(meal.getName())
        .description(meal.getDescription())
        .meat(meatToDTO(meal.getMeat()))
        .rub(rubToDTO(meal.getRub()))
        .createdByUser(userToDTO(meal.getCreatedBy()))
        .createdAt(meal.getFormattedCreatedAt())
        .build();
  }

  @Override
  public MealNameAndIdDTO mealToNameAndIdDTO(Meal meal) {
    if (meal == null) {
      throw new IllegalArgumentException("Meal cannot be null");
    }
    return MealNameAndIdDTO.builder()
        .id(meal.getId())
        .name(meal.getName())
        .build();
  }

  @Override
  public MealNameIdUserDTO mealNameAndIdToDTO(Meal meal) {
    if (meal == null) {
      throw new IllegalArgumentException("Meal cannot be null");
    }
    return MealNameIdUserDTO.builder()
        .id(meal.getId())
        .name(meal.getName())
        .createdByUser(userToDTO(meal.getCreatedBy()))
        .build();
  }

}
