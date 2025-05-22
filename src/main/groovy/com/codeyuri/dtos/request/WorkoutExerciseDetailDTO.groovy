package com.codeyuri.dtos.request

import com.codeyuri.dtos.response.ExerciseResponseDTO
import io.micronaut.serde.annotation.Serdeable

@Serdeable
class WorkoutExerciseDetailDTO {
    Long workoutPlanExerciseId
    Integer order
    Integer sets
    Integer reps
    ExerciseResponseDTO exercise
}
