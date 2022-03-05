package com.example.ionix.adapter.input.web.ionix.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class IonixRegisterRestResponse {

  @Schema(description = "Register Count", example = "1", type = "integer")
  private Integer registerCount;
}
