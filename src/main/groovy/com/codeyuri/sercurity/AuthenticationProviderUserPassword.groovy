package com.codeyuri.sercurity

import io.micronaut.core.annotation.Nullable
import io.micronaut.security.authentication.*
import jakarta.inject.Singleton
import io.reactivex.Flowable
import org.reactivestreams.Publisher

@Singleton
class AuthenticationProviderUserPassword implements AuthenticationProvider {

    @Override
    Publisher<AuthenticationResponse> authenticate(@Nullable Object httpRequest, AuthenticationRequest authenticationRequest) {
        if (authenticationRequest.identity == "yuri" && authenticationRequest.secret == "1234") {
            return Flowable.just(AuthenticationResponse.success("yuri", ["ROLE_USER"]))
        }
        return Flowable.just(AuthenticationResponse.failure())
    }
}
