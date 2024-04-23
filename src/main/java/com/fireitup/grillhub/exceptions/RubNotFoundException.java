package com.fireitup.grillhub.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RubNotFoundException extends RuntimeException {

  private final Long rubId;

  public RubNotFoundException(Long rubId) {
    super("Rub with ID " + rubId + " doesn't exist");
    this.rubId = rubId;
  }

}
