package com.fireitup.grillhub.services;

import com.fireitup.grillhub.dtos.*;
import com.fireitup.grillhub.entities.*;

public interface DTOConvertService {
  UserDTO userToDTO(User user);

  UserProfileDTO userToUserProfileDTO(User user);

  UserPostsDTO userToUserPostsDTO(User user);

  RubDTO rubToDTO(Rub rub);

  RubNameAndIdDTO rubToNameAndIdDTO(Rub rub);

  RubInMealsDTO rubInMealsToDTO(Rub rub);

  MeatDTO meatToDTO(Meat meat);

  SpiceDTO spiceToDTO(Spice spice);

  MealToPostDTO mealToPostToDTO(Meal meal);

  MealDTO mealToDTO(Meal meal);

  MealNameAndIdDTO mealToNameAndIdDTO(Meal meal);

  MealNameIdUserDTO mealNameAndIdToDTO(Meal meal);

}
