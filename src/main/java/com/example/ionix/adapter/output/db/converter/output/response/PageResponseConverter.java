package com.example.ionix.adapter.output.db.converter.output.response;

import com.example.ionix.entity.common.PageResponse;
import lombok.Builder;
import lombok.Data;

import java.util.function.Function;

public class PageResponseConverter implements Function<PageResponseConverter.Wrapper, PageResponse> {
  @Override
  public PageResponse apply(Wrapper wrapper) {
    if (wrapper == null) {
      return null;
    }
    return PageResponse.builder()
             .numberOfItems(wrapper.totalElements)
             .numberOfPages(wrapper.totalPages)
             .build();
  }

  /**
   * Wrapper class.
   */
  @Data
  @Builder
  public static class Wrapper {

    private Long totalElements;
    private Integer totalPages;
  }
}
