package com.fireitup.grillhub.controllers;

import com.fireitup.grillhub.dtos.ErrorMessageDTO;
import com.fireitup.grillhub.dtos.UserProfileDTO;
import com.fireitup.grillhub.entities.User;
import com.fireitup.grillhub.exceptions.MealNotFoundException;
import com.fireitup.grillhub.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/profile")
  public ResponseEntity<UserProfileDTO> getUserProfile(@AuthenticationPrincipal User user) {
    if (user == null) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    return ResponseEntity.ok().body(userService.getUserProfileById(user.getId()));
  }

  @GetMapping("/user/{id}")
  public ResponseEntity getUserPosts(@PathVariable Long id) {
    if (id == null) {
      ErrorMessageDTO errorMsg = new ErrorMessageDTO("Input data are not valid");
      return ResponseEntity.status(400).body(errorMsg);
    }
    try {
      return ResponseEntity.ok().body(userService.getUserPostsById(id));
    } catch (MealNotFoundException e) {
      ErrorMessageDTO errorMsg = new ErrorMessageDTO("This user doesn't exist!");
      return ResponseEntity.status(404).body(errorMsg);
    }
  }
}
