package com.example.ionix.adapter.input.web.common.converter;

import com.example.ionix.adapter.input.web.common.model.PageRestResponse;
import com.example.ionix.entity.common.PageResponse;

import java.util.function.Function;

public class PageRestResponseConverter implements Function<PageResponse, PageRestResponse> {

  @Override
  public PageRestResponse apply(PageResponse pageResponse) {
    if (pageResponse == null) {
      return null;
    }
    return PageRestResponse.builder()
             .totalNumberOfItems(pageResponse.getNumberOfItems())
             .numberOfPages(pageResponse.getNumberOfPages())
             .build();
  }
}
