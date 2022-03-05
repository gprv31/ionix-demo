package com.example.ionix.adapter.output.db;

import com.example.ionix.adapter.output.db.entity.UserEntity;
import com.example.ionix.adapter.output.db.repository.UserRepository;
import com.example.ionix.adapter.output.db.specification.UserJpaSpecification;
import com.example.ionix.domain.port.output.UserPort;
import com.example.ionix.entity.user.request.CreateUserRequest;
import com.example.ionix.entity.user.request.PagedUsersRequest;
import com.example.ionix.entity.user.response.PagedUsersResponse;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.function.Function;

@Slf4j
@RequiredArgsConstructor
public class UserPortImpl implements UserPort {

  private final UserRepository userRepository;
  private final UserJpaSpecification userJpaSpecification;

  private final Function<CreateUserRequest, UserEntity> userEntityConverter;
  private final Function<Page<UserEntity>, PagedUsersResponse> pagedUsersResponseConverter;

  @Override
  public Completable saveUserInformation(CreateUserRequest createUserRequest) {
    log.info("Starting UserPortImpl.saveUserInformation method");
    return Completable.fromAction(() -> userRepository.save(userEntityConverter.apply(createUserRequest)));
  }

  @Override
  public Single<PagedUsersResponse> getAllUsers(PagedUsersRequest pagedUsersRequest) {
    log.info("Starting UserPortImpl.getAllUsers method");
    return Single.fromCallable(() -> {
      Page<UserEntity> userEntityPage = userRepository.findAll(
        userJpaSpecification.obtainSpecification(pagedUsersRequest),
        PageRequest.of(pagedUsersRequest.getCurrentPage() - 1, pagedUsersRequest.getPageSize()));
      return pagedUsersResponseConverter.apply(userEntityPage);
    });
  }
}
