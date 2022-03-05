package com.example.ionix.domain.interactor;

import com.example.ionix.domain.port.input.IonixUseCase;
import com.example.ionix.domain.port.output.IonixPort;
import com.example.ionix.entity.user.response.IonixResponseMock;
import io.reactivex.rxjava3.core.Single;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class IonixUseCaseImplTest {

  private IonixUseCase ionixUseCase;

  @Mock
  public IonixPort ionixPort;

  @Before
  public void before() {
    ionixUseCase = new IonixUseCaseImpl(ionixPort);
  }

  @Test
  public void getUsersTest() {
    String plainText = "1-9";
    when(ionixPort.getIonixInformation(any())).thenReturn(Single.just(IonixResponseMock.getMock()));
    ionixUseCase.getIonixInformation(plainText)
      .test()
      .assertComplete()
      .assertNoErrors()
      .dispose();
  }

}
