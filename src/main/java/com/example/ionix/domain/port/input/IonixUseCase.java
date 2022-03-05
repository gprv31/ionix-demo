package com.example.ionix.domain.port.input;

import com.example.ionix.entity.ionix.response.IonixResponse;
import io.reactivex.rxjava3.core.Single;

public interface IonixUseCase {
  Single<IonixResponse> getIonixInformation(String plainText);
}
