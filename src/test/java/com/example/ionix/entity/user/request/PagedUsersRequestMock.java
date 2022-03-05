package com.example.ionix.entity.user.request;

public class PagedUsersRequestMock {

  public static PagedUsersRequest getMock(){
    return PagedUsersRequest.builder()
      .searchByEmail("mail@mail.com")
      .currentPage(1)
      .pageSize(1)
      .build();
  }
}
