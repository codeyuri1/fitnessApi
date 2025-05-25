package com.codeyuri.dtos.request

import io.micronaut.serde.annotation.Serdeable

import java.time.DayOfWeek

@Serdeable
class WorkoutPlanDayCreateDTO {
    Long workoutPlanId
    DayOfWeek dayOfWeek
}
