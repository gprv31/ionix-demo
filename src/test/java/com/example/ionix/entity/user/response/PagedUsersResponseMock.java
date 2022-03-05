package com.example.ionix.entity.user.response;

import com.example.ionix.entity.common.model.PageResponseMock;
import com.example.ionix.entity.user.UserMock;

import java.util.Collections;

public class PagedUsersResponseMock {

  public static PagedUsersResponse getMock() {
    return PagedUsersResponse.builder()
      .page(PageResponseMock.getMock())
      .userList(Collections.singletonList(UserMock.getMock()))
      .build();
  }
}
