package com.codeyuri.mappers

import com.codeyuri.domain.WorkoutPlanExercise
import com.codeyuri.dtos.request.WorkoutPlanExerciseDTO
import com.codeyuri.dtos.response.WorkoutPlanExerciseResponseDTO
import io.micronaut.serde.annotation.Serdeable
import jakarta.inject.Singleton

@Singleton
@Serdeable
class WorkoutPlanExerciseMapper {

    WorkoutPlanExercise toEntity(WorkoutPlanExerciseDTO dto) {
        new WorkoutPlanExercise(
                workoutPlanDayId: dto.workoutPlanDayId,
                exerciseId: dto.exerciseId,
                sequence: dto.sequence,
                sets: dto.sets,
                reps: dto.reps
        )
    }

    WorkoutPlanExerciseResponseDTO toDTO(WorkoutPlanExercise entity) {
        new WorkoutPlanExerciseResponseDTO(
                id: entity.id,
                workoutPlanDayId: entity.workoutPlanDayId,
                exerciseId: entity.exerciseId,
                sequence: entity.sequence,
                sets: entity.sets,
                reps: entity.reps
        )
    }

    List<WorkoutPlanExerciseResponseDTO> toDTOList(Iterable<WorkoutPlanExercise> list) {
        list.collect { toDTO(it) }
    }
}
