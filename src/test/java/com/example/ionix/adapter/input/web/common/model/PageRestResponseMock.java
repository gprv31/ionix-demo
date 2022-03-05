package com.example.ionix.adapter.input.web.common.model;

public class PageRestResponseMock {

  public static PageRestResponse getMock() {
    return PageRestResponse.builder()
      .numberOfPages(1)
      .totalNumberOfItems(1L)
      .build();
  }
}
