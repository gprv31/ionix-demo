package com.example.ionix.application.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

@Slf4j
@ControllerAdvice
public class ErrorHandlingController extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<IonixExceptionResponse> generalException(Exception e) {
    IonixExceptionResponse ionixExceptionResponse = new IonixExceptionResponse();
    ionixExceptionResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
    ionixExceptionResponse.setMessage(e.getMessage());
    return new ResponseEntity<>(ionixExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(value = ConstraintViolationException.class)
  public ResponseEntity<IonixExceptionResponse> constraintException(Exception e) {
    IonixExceptionResponse ionixExceptionResponse = new IonixExceptionResponse();
    ionixExceptionResponse.setCode(HttpStatus.BAD_REQUEST.value());
    ionixExceptionResponse.setMessage(e.getMessage());
    return new ResponseEntity<>(ionixExceptionResponse, HttpStatus.BAD_REQUEST);
  }
}
