package com.example.ionix.adapter.input.web.user.model.converter;

import com.example.ionix.adapter.input.web.user.model.request.CreateUserRestRequest;
import com.example.ionix.entity.user.request.CreateUserRequest;

import java.util.function.Function;

public class CreateUserRequestConverter implements Function<CreateUserRestRequest, CreateUserRequest> {

  @Override
  public CreateUserRequest apply(CreateUserRestRequest createUserRestRequest) {
    if (createUserRestRequest == null) {
      return null;
    }
    return CreateUserRequest.builder()
      .userName(createUserRestRequest.getUserName())
      .name(createUserRestRequest.getName())
      .email(createUserRestRequest.getEmail())
      .phone(createUserRestRequest.getPhone()).build();
  }
}
