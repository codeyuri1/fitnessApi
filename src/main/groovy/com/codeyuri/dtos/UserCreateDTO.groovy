package com.codeyuri.dtos

import io.micronaut.core.annotation.Introspected
import jakarta.validation.constraints.*

import java.time.LocalDate

@Introspected
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