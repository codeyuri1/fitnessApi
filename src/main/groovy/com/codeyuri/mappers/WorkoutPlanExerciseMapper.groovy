package com.codeyuri.mappers

import com.codeyuri.domain.WorkoutPlanExercise
import com.codeyuri.dtos.request.WorkoutPlanExerciseDTO
import io.micronaut.serde.annotation.Serdeable
import jakarta.inject.Singleton

@Singleton
@Serdeable
class WorkoutPlanExerciseMapper {

    WorkoutPlanExerciseDTO toDTO(WorkoutPlanExercise entity) {
        new WorkoutPlanExerciseDTO(
                id: entity.id,
                workoutPlanId: entity.workoutPlanId,
                exerciseId: entity.exerciseId,
                sequence: entity.sequence,
                sets: entity.sets,
                reps: entity.reps
        )
    }

    WorkoutPlanExercise toEntity(WorkoutPlanExerciseDTO dto) {
        new WorkoutPlanExercise(
                id: dto.id,
                workoutPlanId: dto.workoutPlanId,
                exerciseId: dto.exerciseId,
                sequence: dto.sequence,
                sets: dto.sets,
                reps: dto.reps
        )
    }

    List<WorkoutPlanExerciseDTO> toDTOList(Iterable<WorkoutPlanExercise> list) {
        list.collect { toDTO(it) }
    }
}
