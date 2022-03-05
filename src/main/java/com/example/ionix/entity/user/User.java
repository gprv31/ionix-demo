package com.example.ionix.entity.user;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class User {
  private String name;
  private String userName;
  private String email;
  private String phone;
}
