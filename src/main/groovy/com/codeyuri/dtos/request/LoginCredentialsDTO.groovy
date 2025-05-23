package com.codeyuri.dtos.request

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable
import jakarta.validation.constraints.NotBlank

@Introspected
@Serdeable
class LoginCredentialsDTO {
    @NotBlank
    String username
    @NotBlank
    String password
}
