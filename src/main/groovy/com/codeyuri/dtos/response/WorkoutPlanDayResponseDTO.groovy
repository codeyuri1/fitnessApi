package com.codeyuri.dtos.response

import io.micronaut.serde.annotation.Serdeable

import java.time.DayOfWeek

@Serdeable
class WorkoutPlanDayResponseDTO {
    Long id
    Long workoutPlanId
    DayOfWeek dayOfWeek
}
