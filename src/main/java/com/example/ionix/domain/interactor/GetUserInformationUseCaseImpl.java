package com.example.ionix.domain.interactor;

import com.example.ionix.domain.port.input.GetUserInformationUseCase;
import com.example.ionix.domain.port.output.UserPort;
import com.example.ionix.entity.user.request.PagedUsersRequest;
import com.example.ionix.entity.user.response.PagedUsersResponse;
import io.reactivex.rxjava3.core.Single;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class GetUserInformationUseCaseImpl implements GetUserInformationUseCase {

  private final UserPort userPort;

  @Override
  public Single<PagedUsersResponse> getUsers(PagedUsersRequest pagedUsersRequest) {
    log.info("Starting GetUserInformationUseCaseImpl.getUsers method");
    return userPort.getAllUsers(pagedUsersRequest)
      .doOnSuccess(i -> log.info("Finished GetUserInformationUseCaseImpl.getUsers method successfully"))
      .doOnError(e -> log.error("Finished GetUserInformationUseCaseImpl.getUsers method with error", e));
  }
}
