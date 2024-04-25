package com.fireitup.grillhub.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserNotFoundException extends RuntimeException {
  private final Long userId;

  public UserNotFoundException(Long userId) {
    super("User with ID " + userId + " doesn't exist");
    this.userId = userId;
  }
}
