package com.codeyuri.dtos.request

import io.micronaut.serde.annotation.Serdeable

import java.time.LocalDate

@Serdeable
class UserWorkoutPlanCreateDTO {

    Long userId
    Long workoutPlanId

    LocalDate dateTo
    LocalDate dateFrom
}
