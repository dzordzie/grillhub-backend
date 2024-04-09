package com.fireitup.grillhub.services;

import com.fireitup.grillhub.dtos.*;
import com.fireitup.grillhub.entities.*;

public interface DTOConvertService {
  UserDTO userToDTO(User user);

  RubDTO rubToDTO(Rub rub);

  MeatDTO meatToDTO(Meat meat);

  SpiceDTO spiceToDTO(Spice spice);

  MealToPostDTO mealToPostToDTO(Meal meal);
}
