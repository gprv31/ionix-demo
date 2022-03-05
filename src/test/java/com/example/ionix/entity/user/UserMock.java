package com.example.ionix.entity.user;

public class UserMock {

  public static User getMock() {
    return User.builder()
      .name("Clayton")
      .userName("smith032")
      .email("mail@mail.com")
      .phone("99999999")
      .build();
  }
}
