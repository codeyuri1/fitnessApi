package com.codeyuri.services


import com.codeyuri.domain.UserWorkoutPlan
import com.codeyuri.domain.WorkoutPlan
import com.codeyuri.domain.WorkoutPlanExercise
import com.codeyuri.dtos.request.UserActualWorkoutPlanDTO
import com.codeyuri.dtos.request.WorkoutExerciseDetailDTO
import com.codeyuri.mappers.ExerciseMapper
import com.codeyuri.repository.UserWorkoutPlanRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton
import jakarta.transaction.Transactional

import java.time.LocalDate

@Singleton
class UserWorkoutPlanService {

    @Inject
    UserWorkoutPlanRepository userWorkoutPlanRepository

    @Inject
    WorkoutPlanService workoutPlanService

    @Inject
    WorkoutPlanExerciseService workoutPlanExerciseService

    @Inject
    ExerciseService exerciseService

    @Inject
    ExerciseMapper exerciseMapper


    @Transactional
    def getUserActualWorkoutPlan(Long userId) {
        LocalDate date = LocalDate.now()
        UserWorkoutPlan planRelation = userWorkoutPlanRepository.findByUserIdAndDateToAfter(userId, date)

        if (!planRelation) {
            return null
        }

        WorkoutPlan workoutPlan = workoutPlanService.findById(planRelation.workoutPlanId).orElse(null)
        if (!workoutPlan) {
            return null
        }

        List<WorkoutPlanExercise> workoutPlanExerciseList = workoutPlanExerciseService.findByWorkoutPlanId(workoutPlan.id)

        List<WorkoutExerciseDetailDTO> exercises = workoutPlanExerciseList.collect { wpe ->
            def exercise = exerciseService.findById(wpe.exerciseId).orElse(null)

            new WorkoutExerciseDetailDTO(
                    workoutPlanExerciseId: wpe.id,
                    order: wpe.sequence,
                    sets: wpe.sets,
                    reps: wpe.reps,
                    exercise: exercise ? exerciseMapper.toDTO(exercise) : null
            )
        }

        return new UserActualWorkoutPlanDTO(
                workoutPlanId: workoutPlan.id,
                title: workoutPlan.title,
                description: workoutPlan.description,
                createdDate: workoutPlan.createdDate,
                duration: workoutPlan.duration,
                exercises: exercises
        )
    }

}
