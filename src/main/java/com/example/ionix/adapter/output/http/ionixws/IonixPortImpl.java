package com.example.ionix.adapter.output.http.ionixws;

import com.example.ionix.adapter.output.http.common.IonixClient;
import com.example.ionix.application.properties.EncryptionValuesProperties;
import com.example.ionix.domain.port.output.IonixPort;
import com.example.ionix.entity.ionix.response.IonixRegisterResponse;
import com.example.ionix.entity.ionix.response.IonixResponse;
import io.reactivex.rxjava3.core.Single;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Slf4j
@AllArgsConstructor
public class IonixPortImpl implements IonixPort {

  private final EncryptionValuesProperties encryptionValuesProperties;

  @Override
  public Single<IonixResponse> getIonixInformation(String plainText) {
    log.info("Starting IonixPortImpl.getIonixInformation method");
    return Single.fromCallable(() -> {
      String encryptedMessageString = encrypt(encryptionValuesProperties.getSecret(), plainText);
      okhttp3.Response response = makeCallAndGetResponse(encryptedMessageString);
      return IonixResponse.builder()
        .responseCode(String.valueOf(response.code()))
        .description(response.code() == 200 ? "OK" : "Error")
        .elapsedTime(response.receivedResponseAtMillis() - response.sentRequestAtMillis())
        .result(IonixRegisterResponse.builder().registerCount(0).build())
        .build();
    });
  }

  private String encrypt(String key, String plainText) {
    try {
      DESKeySpec keySpec = new DESKeySpec(key.getBytes(StandardCharsets.UTF_8));
      SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
      SecretKeySpec spec = new SecretKeySpec(keyFactory.generateSecret(keySpec).getEncoded(), "DES");
      byte[] cleartext = plainText.getBytes(StandardCharsets.UTF_8);
      Cipher cipher = Cipher.getInstance("DES");
      cipher.init(Cipher.ENCRYPT_MODE, spec);
      return Base64.getEncoder().encodeToString(cipher.doFinal(cleartext));
    } catch (Exception e) {
      log.error("Error ocurred on IonixPortImpl.encrypt method", e);
    }
    return "";
  }
  private okhttp3.Response makeCallAndGetResponse(String encryptedMessageString) throws IOException {
    Retrofit retrofit = new Retrofit.Builder()
      .baseUrl("https://sandbox.ionix.cl/")
      .addConverterFactory(GsonConverterFactory.create())
      .build();
    IonixClient ionixClient = retrofit.create(IonixClient.class);
    Call<Object> call = ionixClient.ionixCall(encryptedMessageString);
    return call.execute().raw();
  }
}
