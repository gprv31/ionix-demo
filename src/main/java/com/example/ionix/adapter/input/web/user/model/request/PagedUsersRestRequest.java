package com.example.ionix.adapter.input.web.user.model.request;

import com.example.ionix.adapter.input.web.user.validators.EmailValid;
import com.example.ionix.adapter.input.web.user.validators.NumberValid;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
public class PagedUsersRestRequest {

  @EmailValid
  @Schema(description = "Search by email", example = "mail@mail.com", required = true, type = "string")
  private String searchByEmail;

  @NumberValid
  @Schema(description = "Current page", example = "1", required = true, type = "integer",
    format = "int32", minimum = "1")
  private String currentPage;

  @NumberValid
  @Schema(description = "Page size", example = "25", required = true, type = "integer",
    format = "int32", minimum = "1")
  private String pageSize;
}
