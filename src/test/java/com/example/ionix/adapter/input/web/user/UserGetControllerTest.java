package com.example.ionix.adapter.input.web.user;

import com.example.ionix.adapter.input.web.user.model.request.PagedUsersRestRequest;
import com.example.ionix.adapter.input.web.user.model.request.PagedUsersRestRequestMock;
import com.example.ionix.adapter.input.web.user.model.response.PagedUsersRestResponse;
import com.example.ionix.adapter.input.web.user.model.response.PagedUsersRestResponseMock;
import com.example.ionix.domain.port.input.GetUserInformationUseCase;
import com.example.ionix.entity.user.request.PagedUsersRequest;
import com.example.ionix.entity.user.request.PagedUsersRequestMock;
import com.example.ionix.entity.user.response.PagedUsersResponse;
import com.example.ionix.entity.user.response.PagedUsersResponseMock;
import io.reactivex.rxjava3.core.Single;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.function.Function;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserGetControllerTest {

  private UserGetController userGetController;

  @Mock
  private GetUserInformationUseCase getUserInformationUseCase;

  @Mock
  private Function<PagedUsersRestRequest, PagedUsersRequest> pagedUsersRequestConverter;

  @Mock
  private Function<PagedUsersResponse, PagedUsersRestResponse> pagedUsersRestResponseConverter;

  @Before
  public void before() {
    userGetController = new UserGetController(getUserInformationUseCase, pagedUsersRequestConverter,
        pagedUsersRestResponseConverter);
  }

  @Test
  public void getUserInformationTest() {
    when(getUserInformationUseCase.getUsers(any())).thenReturn(Single.just(PagedUsersResponseMock.getMock()));
    when(pagedUsersRestResponseConverter.apply(any())).thenReturn(PagedUsersRestResponseMock.getMock());
    when(pagedUsersRequestConverter.apply(any())).thenReturn(PagedUsersRequestMock.getMock());

    userGetController.getUserInformation(PagedUsersRestRequestMock.getMock())
      .test()
      .assertComplete()
      .assertNoErrors()
      .dispose();
  }
}
