package com.example.ionix.adapter.input.web.user.model.response;

public class UserRestResponseMock {

  public static UserRestResponse getMock() {
    return UserRestResponse.builder()
      .name("Clayton")
      .userName("smith032")
      .phone("99999999")
      .email("mail@mail.com")
      .build();
  }
}
