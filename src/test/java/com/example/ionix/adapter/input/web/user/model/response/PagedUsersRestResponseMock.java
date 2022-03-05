package com.example.ionix.adapter.input.web.user.model.response;

import com.example.ionix.adapter.input.web.common.model.PageRestResponse;
import com.example.ionix.adapter.input.web.common.model.PageRestResponseMock;

import java.util.Collections;

public class PagedUsersRestResponseMock {

  public static PagedUsersRestResponse getMock() {
    return PagedUsersRestResponse.builder()
      .page(PageRestResponseMock.getMock())
      .userList(Collections.singletonList(UserRestResponseMock.getMock()))
      .build();
  }
}
