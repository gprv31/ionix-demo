package com.example.ionix.entity.user.response;

import com.example.ionix.entity.common.PageResponse;
import com.example.ionix.entity.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class PagedUsersResponse {
    private PageResponse page;
    private List<User> userList;
}
