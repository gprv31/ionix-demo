package com.example.ionix.adapter.input.web.user.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserRestResponse {

  @Schema(description = "Name", example = "Clayton")
  private String name;

  @Schema(description = "User name", example = "Clayton032")
  private String userName;

  @Schema(description = "User email", example = "Clayton032@mail.com")
  private String email;

  @Schema(description = "User phone number", example = "1")
  private String phone;
}
