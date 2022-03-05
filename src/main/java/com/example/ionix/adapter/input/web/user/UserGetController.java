package com.example.ionix.adapter.input.web.user;

import com.example.ionix.adapter.input.web.user.model.request.PagedUsersRestRequest;
import com.example.ionix.adapter.input.web.user.model.response.PagedUsersRestResponse;
import com.example.ionix.domain.port.input.GetUserInformationUseCase;
import com.example.ionix.entity.user.request.PagedUsersRequest;
import com.example.ionix.entity.user.response.PagedUsersResponse;
import io.reactivex.rxjava3.core.Single;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.function.Function;

@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
@Tag(name = "Users GET", description = "Users GET methods Controller")
public class UserGetController {

  private final GetUserInformationUseCase getUserInformationUseCase;

  private final Function<PagedUsersRestRequest, PagedUsersRequest> pagedUsersRequestConverter;

  private final Function<PagedUsersResponse, PagedUsersRestResponse> pagedUsersRestResponseConverter;


  /**
   * Get all user information by filter.
   *
   * @param pagedUsersRestRequest {@link PagedUsersRestRequest}
   * @return {@link PagedUsersRestResponse}
   *
   */
  @GetMapping(value = "/user", produces = {MediaType.APPLICATION_JSON_VALUE})
  @Operation(summary = "Get User info", description = "Get user information")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Successful operation")
  })
  public Single<PagedUsersRestResponse> getUserInformation(@Valid PagedUsersRestRequest pagedUsersRestRequest) {
    log.info("Starting UserGetController.getUserInformation method");
    return getUserInformationUseCase.getUsers(pagedUsersRequestConverter.apply(pagedUsersRestRequest))
      .map(pagedUsersRestResponseConverter::apply)
      .doOnSuccess(i -> log.info("Finished UserGetController.getUserInformation method"))
      .doOnError(e -> log.error("Finished UserGetController.getUserInformation method with error", e));
  }
}
