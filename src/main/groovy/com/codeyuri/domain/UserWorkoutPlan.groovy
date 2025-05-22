package com.codeyuri.domain

import jakarta.persistence.*

import java.time.LocalDate

@Entity
class UserWorkoutPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    @Column(nullable = false)
    Long workoutPlanId

    @Column(nullable = false)
    Long userId

    LocalDate dateTo

    LocalDate dateFrom
}
