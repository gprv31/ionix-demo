package com.example.ionix.application.configuration;

import com.example.ionix.adapter.input.web.common.converter.PageRestResponseConverter;
import com.example.ionix.adapter.input.web.common.model.PageRestResponse;
import com.example.ionix.adapter.input.web.ionix.model.converter.IonixRegisterRestResponseConverter;
import com.example.ionix.adapter.input.web.ionix.model.converter.IonixRestResponseConverter;
import com.example.ionix.adapter.input.web.ionix.model.response.IonixRegisterRestResponse;
import com.example.ionix.adapter.input.web.ionix.model.response.IonixRestResponse;
import com.example.ionix.adapter.input.web.user.model.converter.CreateUserRequestConverter;
import com.example.ionix.adapter.input.web.user.model.converter.PagedUsersRequestConverter;
import com.example.ionix.adapter.input.web.user.model.converter.PagedUsersRestResponseConverter;
import com.example.ionix.adapter.input.web.user.model.converter.UserRestResponseConverter;
import com.example.ionix.adapter.input.web.user.model.request.CreateUserRestRequest;
import com.example.ionix.adapter.input.web.user.model.request.PagedUsersRestRequest;
import com.example.ionix.adapter.input.web.user.model.response.PagedUsersRestResponse;
import com.example.ionix.adapter.input.web.user.model.response.UserRestResponse;
import com.example.ionix.adapter.output.db.converter.output.response.PagedUsersResponseConverter;
import com.example.ionix.adapter.output.db.entity.UserEntity;
import com.example.ionix.domain.interactor.CreateUserInformationUseCaseImpl;
import com.example.ionix.domain.interactor.GetUserInformationUseCaseImpl;
import com.example.ionix.domain.interactor.IonixUseCaseImpl;
import com.example.ionix.domain.port.input.CreateUserInformationUseCase;
import com.example.ionix.domain.port.input.GetUserInformationUseCase;
import com.example.ionix.domain.port.input.IonixUseCase;
import com.example.ionix.domain.port.output.IonixPort;
import com.example.ionix.domain.port.output.UserPort;
import com.example.ionix.entity.common.PageResponse;
import com.example.ionix.entity.ionix.response.IonixRegisterResponse;
import com.example.ionix.entity.ionix.response.IonixResponse;
import com.example.ionix.entity.user.User;
import com.example.ionix.entity.user.request.CreateUserRequest;
import com.example.ionix.entity.user.request.PagedUsersRequest;
import com.example.ionix.entity.user.response.PagedUsersResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Slf4j
@Configuration
public class ControllerConfiguration {

  /* UseCase Beans Injection */
  @Bean
  public CreateUserInformationUseCase createUserInformationUseCase(UserPort userPort) {
    return new CreateUserInformationUseCaseImpl(userPort);
  }

  @Bean
  public GetUserInformationUseCase getUserInformationUseCase(UserPort userPort) {
    return new GetUserInformationUseCaseImpl(userPort);
  }

  @Bean
  public IonixUseCase getIonixUseCase(IonixPort ionixPort) {
    return new IonixUseCaseImpl(ionixPort);
  }

  /* Request Converter Beans Injection */
  @Bean
  public Function<CreateUserRestRequest, CreateUserRequest> createUserRequestConverter() {
    return new CreateUserRequestConverter();
  }

  @Bean
  public Function<PagedUsersRestRequest, PagedUsersRequest> pagedUsersRequestConverter() {
    return new PagedUsersRequestConverter();
  }

  /* Response Converter Beans Injection */
  @Bean
  public Function<PagedUsersResponse, PagedUsersRestResponse> pagedUsersRestResponseConverter(
      Function<PageResponse, PageRestResponse> pageRestResponseConverter,
      Function<User, UserRestResponse> userRestResponseConverter) {
    return new PagedUsersRestResponseConverter(pageRestResponseConverter, userRestResponseConverter);
  }

  @Bean
  public Function<PageResponse, PageRestResponse> pageRestResponseConverter() {
    return new PageRestResponseConverter();
  }

  @Bean
  public Function<User, UserRestResponse> userRestResponseConverter() {
    return new UserRestResponseConverter();
  }

  @Bean
  public Function<IonixResponse, IonixRestResponse> ionixRestResponseConverter(
      Function<IonixRegisterResponse, IonixRegisterRestResponse> ionixRegisterRestResponseConverter) {
    return new IonixRestResponseConverter(ionixRegisterRestResponseConverter);
  }
  @Bean
  public Function<IonixRegisterResponse, IonixRegisterRestResponse> ionixRegisterRestResponseConverter() {
    return new IonixRegisterRestResponseConverter();
  }
}
