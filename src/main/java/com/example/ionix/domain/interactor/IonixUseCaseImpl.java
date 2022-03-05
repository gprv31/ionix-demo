package com.example.ionix.domain.interactor;

import com.example.ionix.domain.port.input.IonixUseCase;
import com.example.ionix.domain.port.output.IonixPort;
import com.example.ionix.entity.ionix.response.IonixResponse;
import io.reactivex.rxjava3.core.Single;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class IonixUseCaseImpl implements IonixUseCase {

  public final IonixPort ionixPort;

  @Override
  public Single<IonixResponse> getIonixInformation(String plainText) {
    log.info("Starting IonixUseCaseImpl.getIonixInformation method");
    return ionixPort.getIonixInformation(plainText)
      .doOnSuccess(i -> log.info("Finished IonixUseCaseImpl.getIonixInformation method successfully"))
      .doOnError(e -> log.error("Finished IonixUseCaseImpl.getIonixInformation method with error", e));
  }
}
