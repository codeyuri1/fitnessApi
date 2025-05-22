package com.codeyuri.dtos.request

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable
import jakarta.validation.constraints.*

import java.time.LocalDate

@Introspected
@Serdeable
class UserCreateDTO {

    @NotBlank
    @Size(min = 2, max = 100)
    String name

    @NotBlank
    @Email
    String email

    @Past
    LocalDate birthDate

    @NotNull
    @Positive
    Double weight

    @NotNull
    @Positive
    Double height
}