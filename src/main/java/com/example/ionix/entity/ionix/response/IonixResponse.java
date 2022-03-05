package com.example.ionix.entity.ionix.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class IonixResponse {

  private String responseCode;
  private String description;
  private Long elapsedTime;
  private IonixRegisterResponse result;
}
