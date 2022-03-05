package com.example.ionix.adapter.output;

import com.example.ionix.adapter.output.db.UserPortImpl;
import com.example.ionix.adapter.output.db.entity.UserEntity;
import com.example.ionix.adapter.output.db.repository.UserRepository;
import com.example.ionix.adapter.output.db.specification.UserJpaSpecification;
import com.example.ionix.adapter.output.entity.UserEntityMock;
import com.example.ionix.domain.port.output.UserPort;
import com.example.ionix.entity.user.request.CreateUserRequest;
import com.example.ionix.entity.user.request.CreateUserRequestMock;
import com.example.ionix.entity.user.response.PagedUsersResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;

import java.util.function.Function;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserPortImplTest {

  private UserPort userPort;

  @Mock
  private UserRepository userRepository;

  @Mock
  private UserJpaSpecification userJpaSpecification;

  @Mock
  private Function<CreateUserRequest, UserEntity> userEntityConverter;

  @Mock
  private Function<Page<UserEntity>, PagedUsersResponse> pagedUsersResponseConverter;

  @Before
  public void init() {
    userPort = new UserPortImpl(userRepository, userJpaSpecification, userEntityConverter, pagedUsersResponseConverter);
  }

  @Test
  public void saveUserInformation() {
    when(userEntityConverter.apply(any())).thenReturn(UserEntityMock.getMock());

    userPort.saveUserInformation(CreateUserRequestMock.getMock())
      .test()
      .assertNoErrors()
      .assertComplete()
      .dispose();
  }
}
