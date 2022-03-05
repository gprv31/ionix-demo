package com.example.ionix.adapter.input.web.ionix.model.converter;

import com.example.ionix.adapter.input.web.ionix.model.response.IonixRegisterRestResponse;
import com.example.ionix.entity.ionix.response.IonixRegisterResponse;

import java.util.function.Function;

public class IonixRegisterRestResponseConverter implements Function<IonixRegisterResponse, IonixRegisterRestResponse> {

  @Override
  public IonixRegisterRestResponse apply(IonixRegisterResponse ionixRegisterResponse) {
    if (ionixRegisterResponse == null) {
      return null;
    }
    return IonixRegisterRestResponse.builder()
      .registerCount(ionixRegisterResponse.getRegisterCount())
      .build();
  }
}
