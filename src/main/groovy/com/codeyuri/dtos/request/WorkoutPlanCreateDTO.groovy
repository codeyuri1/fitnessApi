package com.codeyuri.dtos.request

import io.micronaut.serde.annotation.Serdeable
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive

@Serdeable
class WorkoutPlanCreateDTO {

    @NotBlank
    String title

    String description

    @Positive
    Integer duration

    List<Long> exerciseIds
}
