package com.example.ionix.entity.user.request;

import lombok.*;

@Setter
@Getter
@Builder
public class PagedUsersRequest {

  private String searchByEmail;
  private Integer currentPage;
  private Integer pageSize;
}
