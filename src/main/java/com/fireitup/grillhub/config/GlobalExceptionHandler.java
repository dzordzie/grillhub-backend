package com.fireitup.grillhub.config;

import com.fireitup.grillhub.dtos.ErrorMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(CustomException.class)
  public ResponseEntity<ErrorMessageDTO> handleCustomException(CustomException ex, WebRequest request) {
    ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO(ex.getMessage());
    return new ResponseEntity<>(errorMessageDTO, HttpStatus.BAD_REQUEST);
  }

}
