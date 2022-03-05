package com.example.ionix.entity.common.model;

import com.example.ionix.entity.common.PageResponse;

public class PageResponseMock {

  public static PageResponse getMock() {
    return PageResponse.builder()
      .numberOfItems(1L)
      .numberOfPages(1)
      .build();
  }
}
