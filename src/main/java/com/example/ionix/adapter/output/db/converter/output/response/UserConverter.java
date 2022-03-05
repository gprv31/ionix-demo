package com.example.ionix.adapter.output.db.converter.output.response;

import com.example.ionix.adapter.output.db.entity.UserEntity;
import com.example.ionix.entity.user.User;

import java.util.function.Function;

public class UserConverter implements Function<UserEntity, User> {

  @Override
  public User apply(UserEntity userEntity) {
    if (userEntity == null) {
      return null;
    }
    return User.builder()
      .name(userEntity.getName())
      .userName(userEntity.getUserName())
      .phone(userEntity.getPhone())
      .email(userEntity.getEmail()).build();
  }
}
