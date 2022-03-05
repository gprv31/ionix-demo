package com.example.ionix.domain.port.output;

import com.example.ionix.entity.ionix.response.IonixResponse;
import io.reactivex.rxjava3.core.Single;

public interface IonixPort {
  Single<IonixResponse> getIonixInformation(String plainText);
}
