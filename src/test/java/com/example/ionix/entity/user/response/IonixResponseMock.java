package com.example.ionix.entity.user.response;

import com.example.ionix.entity.ionix.response.IonixResponse;

public class IonixResponseMock {

  public static IonixResponse getMock() {
    return IonixResponse.builder()
      .responseCode("200")
      .description("Ok")
      .elapsedTime(325L)
      .result(IonixRegisterResponseMock.getMock())
      .build();
  }
}
