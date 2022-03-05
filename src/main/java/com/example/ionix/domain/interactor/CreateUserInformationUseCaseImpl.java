package com.example.ionix.domain.interactor;

import com.example.ionix.domain.port.input.CreateUserInformationUseCase;
import com.example.ionix.domain.port.output.UserPort;
import com.example.ionix.entity.user.request.CreateUserRequest;
import io.reactivex.rxjava3.core.Completable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CreateUserInformationUseCaseImpl implements CreateUserInformationUseCase {

  private final UserPort userPort;

  @Override
  public Completable saveUserInformation(CreateUserRequest createUserRequest) {
    log.info("Starting CreateUserInformationUseCaseImpl.saveUserInformation method");
    return userPort.saveUserInformation(createUserRequest)
      .doOnComplete(() -> log.info("Finished CreateUserInformationUseCaseImpl.saveUserInformation method successfully"))
      .doOnError(e -> log.error("Finished CreateUserInformationUseCaseImpl.saveUserInformation method with error", e));
  }
}
