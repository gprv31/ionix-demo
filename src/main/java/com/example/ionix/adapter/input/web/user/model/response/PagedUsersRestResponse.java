package com.example.ionix.adapter.input.web.user.model.response;

import com.example.ionix.adapter.input.web.common.model.PageRestResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
public class PagedUsersRestResponse {

  @Schema(description = "Object Page")
  private PageRestResponse page;

  @Schema(description = "List of Users")
  private List<UserRestResponse> userList;
}
