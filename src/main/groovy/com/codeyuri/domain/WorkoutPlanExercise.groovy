package com.codeyuri.domain

import jakarta.persistence.*

@Entity
class WorkoutPlanExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    @Column(nullable = false)
    Long exerciseId

    @Column(nullable = false)
    Integer sequence

    Integer sets
    Integer reps

    @Column(nullable = false)
    Long workoutPlanDayId
}

