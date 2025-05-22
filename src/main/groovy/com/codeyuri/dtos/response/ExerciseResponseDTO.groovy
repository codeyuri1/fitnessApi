package com.codeyuri.dtos.response

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable

@Serdeable
@Introspected
class ExerciseResponseDTO {

    Long id
    String name
    String description
    String muscleGroup
    String difficulty
    Integer duration
}
