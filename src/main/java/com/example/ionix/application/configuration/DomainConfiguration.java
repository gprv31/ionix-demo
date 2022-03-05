package com.example.ionix.application.configuration;

import com.example.ionix.adapter.output.db.UserPortImpl;
import com.example.ionix.adapter.output.db.converter.UserEntityConverter;
import com.example.ionix.adapter.output.db.converter.output.response.PagedUsersResponseConverter;
import com.example.ionix.adapter.output.db.converter.output.response.UserConverter;
import com.example.ionix.adapter.output.db.entity.UserEntity;
import com.example.ionix.adapter.output.db.repository.UserRepository;
import com.example.ionix.adapter.output.db.specification.UserJpaSpecification;
import com.example.ionix.adapter.output.http.ionixws.IonixPortImpl;
import com.example.ionix.application.properties.EncryptionValuesProperties;
import com.example.ionix.domain.port.output.IonixPort;
import com.example.ionix.domain.port.output.UserPort;
import com.example.ionix.entity.user.User;
import com.example.ionix.entity.user.request.CreateUserRequest;
import com.example.ionix.entity.user.response.PagedUsersResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

import java.util.function.Function;

@Slf4j
@Configuration
public class DomainConfiguration {

  /* Output Converter Beans Injection */
  @Bean
  public Function<Page<UserEntity>, PagedUsersResponse> pagedUsersResponseConverter(
      Function<UserEntity, User> userConverter) {
    return new PagedUsersResponseConverter(userConverter);
  }

  @Bean
  public Function<UserEntity, User> userConverter() {
    return new UserConverter();
  }

  /* Internal Converter Beans Injection */
  @Bean
  public Function<CreateUserRequest, UserEntity> userEntityConverter() {
    return new UserEntityConverter();
  }

  /* Jpa Specification Beans Injection */

  @Bean
  public UserJpaSpecification userJpaSpecification() {
    return new UserJpaSpecification();
  }

  /* Port Beans Injection */
  @Bean
  public UserPort userPort(UserRepository userRepository,
                           UserJpaSpecification userJpaSpecification,
                           Function<CreateUserRequest, UserEntity> userEntityConverter,
                           Function<Page<UserEntity>, PagedUsersResponse> pagedUsersResponseConverter) {
    return new UserPortImpl(userRepository, userJpaSpecification, userEntityConverter, pagedUsersResponseConverter);
  }

  @Bean
  public IonixPort IonixPort(EncryptionValuesProperties encryptionValuesProperties) {
    return new IonixPortImpl(encryptionValuesProperties);
  }


}
