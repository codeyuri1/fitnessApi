package com.codeyuri.dtos.request

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive

@Serdeable
@Introspected
class ExerciseCreateDTO {

    @NotBlank
    String name

    String description

    @NotBlank
    String muscleGroup

    @NotBlank
    String difficulty

    @Positive
    Integer duration
}
