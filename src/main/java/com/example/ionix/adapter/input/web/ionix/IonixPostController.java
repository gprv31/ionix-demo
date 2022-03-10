package com.example.ionix.adapter.input.web.ionix;

import com.example.ionix.adapter.input.web.ionix.model.response.IonixRestResponse;
import com.example.ionix.domain.port.input.IonixUseCase;
import com.example.ionix.entity.ionix.response.IonixResponse;
import io.reactivex.rxjava3.core.Single;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Function;

@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
@Tag(name = "Ionix POST", description = "Ionix POST methods Controller")
public class IonixPostController {

  private final IonixUseCase ionixUseCase;

  private final Function<IonixResponse, IonixRestResponse> ionixRestResponseConverter;

  /**
   * Obtain information by Ionix Web Service.
   *
   * @return {@link Object}
   *
   */
  @PostMapping(value = "/ionix", produces = {MediaType.APPLICATION_JSON_VALUE})
  @Operation(summary = "Ionix Post", description = "Get Ionix service information")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Successful operation",
      content = {@Content(schema = @Schema(implementation = IonixRestResponse.class))})
  })
  public Single<IonixRestResponse> saveUserInformation(@RequestParam String rut) {
    log.info("Starting IonixPostController.saveUserInformation method");
    return ionixUseCase.getIonixInformation(rut)
      .map(ionixRestResponseConverter::apply)
      .doOnSuccess(i ->  log.info("Finished IonixPostController.saveUserInformation method"))
      .doOnError(e -> log.error("Finished IonixPostController.saveUserInformation method with error", e));
  }
}
