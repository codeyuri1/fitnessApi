package com.codeyuri.dtos.request

import io.micronaut.serde.annotation.Serdeable

@Serdeable
class WorkoutPlanExerciseDTO {

    Long id
    Long workoutPlanDayId
    Long exerciseId
    Integer sequence
    Integer sets
    Integer reps
}
