package com.example.ionix.adapter.input.web.user;

import com.example.ionix.adapter.input.web.user.model.request.CreateUserRestRequest;
import com.example.ionix.adapter.input.web.user.model.request.CreateUserRestRequestMock;
import com.example.ionix.domain.port.input.CreateUserInformationUseCase;
import com.example.ionix.entity.user.request.CreateUserRequest;
import com.example.ionix.entity.user.request.CreateUserRequestMock;
import io.reactivex.rxjava3.core.Completable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.function.Function;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserPostControllerTest {

  private UserPostController userPostController;

  @Mock
  private CreateUserInformationUseCase createUserInformationUseCase;

  @Mock
  private Function<CreateUserRestRequest, CreateUserRequest> createUserRequestConverter;

  @Before
  public void before() {
    userPostController = new UserPostController(createUserInformationUseCase, createUserRequestConverter);
  }

  @Test
  public void saveUserInformationTest() {
    when(createUserInformationUseCase.saveUserInformation(any())).thenReturn(Completable.complete());
    when(createUserRequestConverter.apply(any())).thenReturn(CreateUserRequestMock.getMock());

    userPostController.saveUserInformation(CreateUserRestRequestMock.getMock())
      .test()
      .assertComplete()
      .assertNoErrors()
      .dispose();
  }
}
