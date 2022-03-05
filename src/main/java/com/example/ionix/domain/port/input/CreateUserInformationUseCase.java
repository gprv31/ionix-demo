package com.example.ionix.domain.port.input;

import com.example.ionix.entity.user.request.CreateUserRequest;
import io.reactivex.rxjava3.core.Completable;

public interface CreateUserInformationUseCase {
    Completable saveUserInformation(CreateUserRequest createUserRequest);
}
