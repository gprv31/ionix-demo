package com.example.ionix.entity.common;

import lombok.*;

@Setter
@Getter
@Builder

public class PageResponse {
  private Long numberOfItems;
  private Integer numberOfPages;
}
