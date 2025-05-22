package com.codeyuri.dtos.response

import io.micronaut.serde.annotation.Serdeable

import java.time.LocalDate

@Serdeable
class WorkoutPlanResponseDTO {
    Long id
    String title
    String description
    LocalDate createdDate
    Integer duration

    List<ExerciseResponseDTO> exercises = []
}
