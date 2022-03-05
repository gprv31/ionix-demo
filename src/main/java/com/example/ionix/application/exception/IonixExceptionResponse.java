package com.example.ionix.application.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class IonixExceptionResponse {
  private int code;
  private String message;
}
