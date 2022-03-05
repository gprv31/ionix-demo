package com.example.ionix.adapter.input.web.user.model.request;

import com.example.ionix.adapter.input.web.user.validators.EmailValid;
import com.example.ionix.adapter.input.web.user.validators.NameValid;
import com.example.ionix.adapter.input.web.user.validators.PhoneValid;
import com.example.ionix.adapter.input.web.user.validators.UserNameValid;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateUserRestRequest {

  @NameValid(required = true)
  @Schema(description = "Name", example = "Clayton", required = true, type = "string")
  private String name;

  @UserNameValid(required = true)
  @Schema(description = "User name", example = "Clayton032", required = true, type = "string")
  private String userName;

  @EmailValid(required = true)
  @Schema(description = "User email", example = "Clayton032@mail.com", required = true, type = "string")
  private String email;

  @PhoneValid(required = true)
  @Schema(description = "User phone number", example = "1", required = true, type = "integer", format = "int32")
  private String phone;
}
