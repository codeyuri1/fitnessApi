package com.codeyuri.dtos.request

import io.micronaut.serde.annotation.Serdeable

@Serdeable
class WorkoutPlanExerciseDTO {

    Long id
    Long workoutPlanId
    Long exerciseId
    Integer order
    Integer sets
    Integer reps
}
