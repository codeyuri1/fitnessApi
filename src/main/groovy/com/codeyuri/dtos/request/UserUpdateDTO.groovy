package com.codeyuri.dtos.request

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Past
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.Size

import java.time.LocalDate

@Introspected
@Serdeable
class UserUpdateDTO {

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