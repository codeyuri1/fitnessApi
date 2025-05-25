package com.codeyuri.repository

import com.codeyuri.domain.WorkoutPlanExercise
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface WorkoutPlanExerciseRepository extends CrudRepository<WorkoutPlanExercise, Long> {
    List<WorkoutPlanExercise> findByWorkoutPlanId(Long workoutPlanId)

    List<WorkoutPlanExercise> findByWorkoutPlanDayId(Long workoutPlanDayId)

}