package com.example.ionix.domain.interactor;

import com.example.ionix.domain.port.input.GetUserInformationUseCase;
import com.example.ionix.domain.port.output.UserPort;
import com.example.ionix.entity.user.request.PagedUsersRequestMock;
import com.example.ionix.entity.user.response.PagedUsersResponseMock;
import io.reactivex.rxjava3.core.Single;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetUserInformationUseCaseImplTest {

  private GetUserInformationUseCase getUserInformationUseCase;

  @Mock
  private UserPort userPort;

  @Before
  public void before() {
    getUserInformationUseCase = new GetUserInformationUseCaseImpl(userPort);
  }

  @Test
  public void getUsersTest() {
    when(userPort.getAllUsers(any())).thenReturn(Single.just(PagedUsersResponseMock.getMock()));
    getUserInformationUseCase.getUsers(PagedUsersRequestMock.getMock())
      .test()
      .assertComplete()
      .assertNoErrors()
      .dispose();
  }
}
