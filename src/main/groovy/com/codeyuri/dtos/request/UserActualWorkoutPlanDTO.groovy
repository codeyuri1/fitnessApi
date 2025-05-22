package com.codeyuri.dtos.request

import io.micronaut.serde.annotation.Serdeable

import java.time.LocalDate

@Serdeable
class UserActualWorkoutPlanDTO {
    Long workoutPlanId
    String title
    String description
    LocalDate createdDate
    Integer duration
    List<WorkoutExerciseDetailDTO> exercises
}
