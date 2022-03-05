package com.example.ionix.domain.interactor;

import com.example.ionix.adapter.input.web.user.model.request.PagedUsersRestRequestMock;
import com.example.ionix.adapter.input.web.user.model.response.PagedUsersRestResponseMock;
import com.example.ionix.domain.port.input.CreateUserInformationUseCase;
import com.example.ionix.domain.port.output.UserPort;
import com.example.ionix.entity.user.request.CreateUserRequestMock;
import com.example.ionix.entity.user.request.PagedUsersRequestMock;
import com.example.ionix.entity.user.response.PagedUsersResponseMock;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreateUserInformationUseCaseImplTest {

  private CreateUserInformationUseCase createUserInformationUseCase;

  @Mock
  private UserPort userPort;

  @Before
  public void before() {
    createUserInformationUseCase = new CreateUserInformationUseCaseImpl(userPort);
  }

  @Test
  public void getUserInformationTest() {
    when(userPort.saveUserInformation(any())).thenReturn(Completable.complete());
    createUserInformationUseCase.saveUserInformation(CreateUserRequestMock.getMock())
      .test()
      .assertComplete()
      .assertNoErrors()
      .dispose();
  }
}
