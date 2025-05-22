package com.codeyuri.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class WorkoutPlanExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    @Column(nullable = false)
    Long workoutPlanId

    @Column(nullable = false)
    Long exerciseId

    @Column(nullable = false)
    Integer sequence

    Integer sets
    Integer reps
}

