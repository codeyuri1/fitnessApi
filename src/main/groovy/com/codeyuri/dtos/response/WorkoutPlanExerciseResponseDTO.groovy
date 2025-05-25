package com.codeyuri.dtos.response

import io.micronaut.serde.annotation.Serdeable

@Serdeable
class WorkoutPlanExerciseResponseDTO {
    Long id
    Long workoutPlanDayId
    Long exerciseId
    Integer sequence
    Integer sets
    Integer reps
}
