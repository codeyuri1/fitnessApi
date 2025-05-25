package com.codeyuri.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

import java.time.DayOfWeek

@Entity
class WorkoutPlanDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    @Column(nullable = false)
    Long workoutPlanId

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    DayOfWeek dayOfWeek
}