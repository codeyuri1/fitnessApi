package com.codeyuri.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class WorkoutPlanExercise {

    @Id
    @GeneratedValue
    Long id

    @Column(nullable = false)
    Long workoutPlanId

    @Column(nullable = false)
    Long exerciseId

    @Column(nullable = false)
    Integer order

    Integer sets
    Integer reps
}

