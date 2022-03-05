package com.example.ionix.adapter.input.web.user.model.converter;


import com.example.ionix.adapter.input.web.user.model.request.PagedUsersRestRequest;
import com.example.ionix.entity.user.request.PagedUsersRequest;

import java.util.function.Function;

public class PagedUsersRequestConverter implements Function<PagedUsersRestRequest, PagedUsersRequest> {

  @Override
  public PagedUsersRequest apply(PagedUsersRestRequest pagedUsersRestRequest) {
    if (pagedUsersRestRequest == null) {
      return null;
    }
    return PagedUsersRequest.builder()
             .searchByEmail(pagedUsersRestRequest.getSearchByEmail())
             .currentPage(Integer.valueOf(pagedUsersRestRequest.getCurrentPage()))
             .pageSize(Integer.valueOf(pagedUsersRestRequest.getPageSize()))
             .build();
  }
}
