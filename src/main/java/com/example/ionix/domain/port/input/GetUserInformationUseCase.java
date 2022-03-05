package com.example.ionix.domain.port.input;

import com.example.ionix.entity.user.request.PagedUsersRequest;
import com.example.ionix.entity.user.response.PagedUsersResponse;
import io.reactivex.rxjava3.core.Single;

public interface GetUserInformationUseCase {
  Single<PagedUsersResponse> getUsers(PagedUsersRequest pagedUsersRequest);
}
