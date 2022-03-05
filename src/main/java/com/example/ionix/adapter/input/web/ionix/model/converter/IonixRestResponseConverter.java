package com.example.ionix.adapter.input.web.ionix.model.converter;

import com.example.ionix.adapter.input.web.ionix.model.response.IonixRegisterRestResponse;
import com.example.ionix.adapter.input.web.ionix.model.response.IonixRestResponse;
import com.example.ionix.entity.ionix.response.IonixRegisterResponse;
import com.example.ionix.entity.ionix.response.IonixResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@RequiredArgsConstructor
public class IonixRestResponseConverter implements Function<IonixResponse, IonixRestResponse> {

  private final Function<IonixRegisterResponse, IonixRegisterRestResponse> ionixRegisterRestResponseConverter;
  @Override
  public IonixRestResponse apply(IonixResponse ionixResponse) {
    if (ionixResponse == null) {
      return null;
    }
    return IonixRestResponse.builder()
      .responseCode(ionixResponse.getResponseCode())
      .description(ionixResponse.getDescription())
      .elapsedTime(ionixResponse.getElapsedTime())
      .result(ionixRegisterRestResponseConverter.apply(ionixResponse.getResult()))
      .build();
  }
}
