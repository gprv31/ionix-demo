package com.example.ionix.adapter.output.entity;

import com.example.ionix.adapter.output.db.entity.UserEntity;

public class UserEntityMock {

  public static UserEntity getMock() {
    UserEntity userEntity = new UserEntity();
    userEntity.setId(1L);
    userEntity.setUserName("smith032");
    userEntity.setName("Clayton");
    userEntity.setPhone("999999999");
    userEntity.setEmail("mail@mail.com");
    return userEntity;
  }
}
