package com.codeyuri.dtos.response

import io.micronaut.serde.annotation.Serdeable

import java.time.LocalDate

@Serdeable
class UserWorkoutPlanResponseDTO {

    Long id
    Long userId
    Long workoutPlanId

    LocalDate dateTo
    LocalDate dateFrom
}
