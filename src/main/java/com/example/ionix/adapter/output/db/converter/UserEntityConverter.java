package com.example.ionix.adapter.output.db.converter;

import com.example.ionix.adapter.output.db.entity.UserEntity;
import com.example.ionix.entity.user.request.CreateUserRequest;

import java.util.function.Function;

public class UserEntityConverter implements Function<CreateUserRequest, UserEntity> {

  @Override
  public UserEntity apply(CreateUserRequest createUserRequest) {
    if (createUserRequest == null) {
      return null;
    }
    UserEntity userEntity = new UserEntity();
    userEntity.setName(createUserRequest.getName().toUpperCase());
    userEntity.setUserName(createUserRequest.getUserName().toUpperCase());
    userEntity.setEmail(createUserRequest.getEmail().toLowerCase());
    userEntity.setPhone(createUserRequest.getPhone());
    return userEntity;
  }
}
