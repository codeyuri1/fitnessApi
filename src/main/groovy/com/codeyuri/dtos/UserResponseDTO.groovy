package com.codeyuri.dtos

import io.micronaut.core.annotation.Introspected

import java.time.LocalDate

@Introspected
class UserResponseDTO {

    Long id
    String name
    String email
    LocalDate birthDate
    Double weight
    Double height
}
