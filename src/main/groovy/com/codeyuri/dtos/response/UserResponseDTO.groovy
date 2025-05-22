package com.codeyuri.dtos.response

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable

import java.time.LocalDate

@Introspected
@Serdeable
class UserResponseDTO {

    Long id
    String name
    String email
    LocalDate birthDate
    Double weight
    Double height
}
