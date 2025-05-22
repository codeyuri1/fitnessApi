package com.codeyuri.services

import com.codeyuri.domain.WorkoutPlanExercise
import com.codeyuri.mappers.WorkoutPlanExerciseMapper
import com.codeyuri.repository.WorkoutPlanExerciseRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class WorkoutPlanExerciseService {

    @Inject
    WorkoutPlanExerciseRepository repository
    @Inject
    WorkoutPlanExerciseMapper mapper


    WorkoutPlanExercise save(WorkoutPlanExercise entity) {
        repository.save(entity)
    }

    List<WorkoutPlanExercise> findByWorkoutPlanId(Long workoutPlanId) {
        repository.findByWorkoutPlanId(workoutPlanId)
    }

    void delete(Long id) {
        repository.deleteById(id)
    }
}
