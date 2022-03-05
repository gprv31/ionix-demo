package com.example.ionix.entity.user.response;

import com.example.ionix.entity.ionix.response.IonixRegisterResponse;

public class IonixRegisterResponseMock {

  public static IonixRegisterResponse getMock() {
    return IonixRegisterResponse.builder()
      .registerCount(1)
      .build();
  }
}
