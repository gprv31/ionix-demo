package com.example.ionix.adapter.input.web.user.model.converter;

import com.example.ionix.adapter.input.web.common.model.PageRestResponse;
import com.example.ionix.adapter.input.web.user.model.response.PagedUsersRestResponse;
import com.example.ionix.adapter.input.web.user.model.response.UserRestResponse;
import com.example.ionix.entity.common.PageResponse;
import com.example.ionix.entity.user.User;
import com.example.ionix.entity.user.response.PagedUsersResponse;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PagedUsersRestResponseConverter implements Function<PagedUsersResponse, PagedUsersRestResponse> {

  private final Function<PageResponse, PageRestResponse> pageRestResponseConverter;
  private final Function<User, UserRestResponse> userRestResponseConverter;

  @Override
  public PagedUsersRestResponse apply(PagedUsersResponse pagedUsersResponse) {
    if (pagedUsersResponse == null) {
      return null;
    }
    return PagedUsersRestResponse.builder()
             .page(pageRestResponseConverter.apply(pagedUsersResponse.getPage()))
             .userList(this.buildUserList(pagedUsersResponse.getUserList()))
             .build();
  }

  private List<UserRestResponse> buildUserList(List<User> userList) {
    if (userList == null || userList.isEmpty()) {
      return Collections.emptyList();
    }
    return userList.stream().map(userRestResponseConverter::apply).collect(Collectors.toList());
  }
}
