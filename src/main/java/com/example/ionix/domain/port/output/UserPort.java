package com.example.ionix.domain.port.output;

import com.example.ionix.entity.user.request.CreateUserRequest;
import com.example.ionix.entity.user.request.PagedUsersRequest;
import com.example.ionix.entity.user.response.PagedUsersResponse;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

public interface UserPort {

  Completable saveUserInformation(CreateUserRequest createUserRequest);
  Single<PagedUsersResponse> getAllUsers(PagedUsersRequest pagedUsersRequest);

}
