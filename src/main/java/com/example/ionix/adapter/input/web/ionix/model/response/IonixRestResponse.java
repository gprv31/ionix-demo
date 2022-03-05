package com.example.ionix.adapter.input.web.ionix.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class IonixRestResponse {

  @Schema(description = "ResponseCode", example = "0", type = "string")
  private String responseCode;

  @Schema(description = "Description", example = "OK", type = "string")
  private String description;

  @Schema(description = "Elapsed Time", example = "245", type = "long")
  private Long elapsedTime;

  @Schema(description = "Result")
  private IonixRegisterRestResponse result;

}
