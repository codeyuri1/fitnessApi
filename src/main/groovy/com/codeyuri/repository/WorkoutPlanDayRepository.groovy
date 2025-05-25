package com.codeyuri.repository

import com.codeyuri.domain.WorkoutPlanDay
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

import java.time.DayOfWeek

@Repository
interface WorkoutPlanDayRepository extends CrudRepository<WorkoutPlanDay, Long> {
    List<WorkoutPlanDay> findByWorkoutPlanId(Long workoutPlanId)

    Optional<WorkoutPlanDay> findByWorkoutPlanIdAndDayOfWeek(Long workoutPlanId, DayOfWeek dayOfWeek)
}