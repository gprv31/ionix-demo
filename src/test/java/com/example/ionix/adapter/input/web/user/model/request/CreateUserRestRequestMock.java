package com.example.ionix.adapter.input.web.user.model.request;

public class CreateUserRestRequestMock {

  public static CreateUserRestRequest getMock() {
    return CreateUserRestRequest.builder()
      .name("Clayton")
      .userName("smith032")
      .email("mail@mail.com")
      .phone("99999999")
      .build();
  }
}
