package com.example.ionix.adapter.output.db.converter.output.response;

import com.example.ionix.adapter.output.db.entity.UserEntity;
import com.example.ionix.entity.common.PageResponse;
import com.example.ionix.entity.user.User;
import com.example.ionix.entity.user.response.PagedUsersResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PagedUsersResponseConverter implements Function<Page<UserEntity>, PagedUsersResponse> {

  private final Function<UserEntity, User> userConverter;

  @Override
  public PagedUsersResponse apply(Page<UserEntity> userEntities) {
    if (userEntities == null) {
      return null;
    }
    return PagedUsersResponse.builder()
             .page(this.buildPageResponseConverterWrapper(userEntities))
             .userList(this.buildUsers(userEntities))
             .build();
  }

  private PageResponse buildPageResponseConverterWrapper(Page<UserEntity> userEntities) {
    if (userEntities == null) {
      return null;
    }
    return PageResponse.builder()
             .numberOfItems(userEntities.getTotalElements())
             .numberOfPages(userEntities.getTotalPages())
             .build();
  }

  private List<User> buildUsers(Page<UserEntity> userEntityPageList) {
    if (userEntityPageList == null || userEntityPageList.isEmpty()) {
      return Collections.emptyList();
    }
    return userEntityPageList.get()
             .map(userConverter::apply)
             .collect(Collectors.toList());
  }
}
