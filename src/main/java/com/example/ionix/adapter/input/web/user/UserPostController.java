package com.example.ionix.adapter.input.web.user;

import com.example.ionix.adapter.input.web.user.model.request.CreateUserRestRequest;
import com.example.ionix.domain.port.input.CreateUserInformationUseCase;
import com.example.ionix.entity.user.request.CreateUserRequest;
import io.reactivex.rxjava3.core.Completable;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.function.Function;

@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
@Tag(name = "User POST", description = "User POST methods Controller")
public class UserPostController {

    private final CreateUserInformationUseCase createUserInformationUseCase;

    private final Function<CreateUserRestRequest, CreateUserRequest> createUserRequestConverter;


    /**
     * Save User information.
     *
     * @param createUserRestRequest CreateUserRestRequest
     * @return {@link Completable}
     *
     */
    @PostMapping(value = "/user", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Create User", description = "Save user information")
    @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    public Completable saveUserInformation(@Valid @RequestBody CreateUserRestRequest createUserRestRequest) {
      log.info("Starting UserPostController.saveUserInformation method");
      return createUserInformationUseCase.saveUserInformation(
          createUserRequestConverter.apply(createUserRestRequest))
        .doOnComplete(() -> log.info("Finished UserPostController.saveUserInformation method"))
        .doOnError(e -> log.error("Finished UserPostController.saveUserInformation method with error", e));
    }
}
