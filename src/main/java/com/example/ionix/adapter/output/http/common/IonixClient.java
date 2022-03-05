package com.example.ionix.adapter.output.http.common;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface IonixClient {

  @Headers("Content-Type: application/stream+json")
  @GET("test-tecnico/search")
  Call<Object> ionixCall(@Query("rut") String rut);
}
