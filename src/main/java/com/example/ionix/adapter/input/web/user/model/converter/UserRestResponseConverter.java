package com.example.ionix.adapter.input.web.user.model.converter;

import com.example.ionix.adapter.input.web.user.model.response.UserRestResponse;
import com.example.ionix.entity.user.User;

import java.util.function.Function;

public class UserRestResponseConverter implements Function<User, UserRestResponse> {

  @Override
  public UserRestResponse apply(User user) {
    if (user == null) {
      return null;
    }
    return UserRestResponse.builder()
      .name(user.getName())
      .userName(user.getUserName())
      .email(user.getEmail())
      .phone(user.getPhone()).build();
  }
}
