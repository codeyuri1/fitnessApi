package com.codeyuri.services

import com.codeyuri.domain.WorkoutPlanDay
import com.codeyuri.repository.WorkoutPlanDayRepository
import jakarta.inject.Singleton

import java.time.DayOfWeek

@Singleton
class WorkoutPlanDayService {

    final WorkoutPlanDayRepository repository

    WorkoutPlanDayService(WorkoutPlanDayRepository repository) {
        this.repository = repository
    }

    Optional<WorkoutPlanDay> findByWorkoutPlanIdAndDayOfWeek(Long workoutPlanId, DayOfWeek dayOfWeek) {
        repository.findByWorkoutPlanIdAndDayOfWeek(workoutPlanId, dayOfWeek)
    }

}
