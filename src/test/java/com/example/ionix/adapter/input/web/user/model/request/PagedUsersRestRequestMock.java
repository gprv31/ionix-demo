package com.example.ionix.adapter.input.web.user.model.request;

public class PagedUsersRestRequestMock {

  public static PagedUsersRestRequest getMock() {
    return PagedUsersRestRequest.builder()
      .searchByEmail("mail@mail.com")
      .currentPage("1")
      .pageSize("1")
      .build();
  }
}
