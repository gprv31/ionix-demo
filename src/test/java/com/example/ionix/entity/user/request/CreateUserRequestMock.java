package com.example.ionix.entity.user.request;

public class CreateUserRequestMock {

  public static CreateUserRequest getMock() {
    return CreateUserRequest.builder()
      .name("Clayton")
      .userName("smmith032")
      .phone("99999999")
      .email("mail@mail.com")
      .build();
  }
}
