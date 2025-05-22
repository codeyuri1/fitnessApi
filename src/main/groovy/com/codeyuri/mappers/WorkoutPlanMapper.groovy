package com.codeyuri.mappers

import com.codeyuri.domain.Exercise
import com.codeyuri.domain.WorkoutPlan
import com.codeyuri.dtos.request.WorkoutPlanCreateDTO
import com.codeyuri.dtos.response.WorkoutPlanResponseDTO
import io.micronaut.serde.annotation.Serdeable
import jakarta.inject.Inject

@Singleton
@Serdeable
class WorkoutPlanMapper {
    @Inject
    ExerciseMapper exerciseMapper

    WorkoutPlan toEntity(WorkoutPlanCreateDTO dto) {
        new WorkoutPlan(
                title: dto.title,
                description: dto.description,
                createdDate: LocalDate.now(),
                duration: dto.duration
        )
    }

    WorkoutPlanResponseDTO toDTO(WorkoutPlan plan, List<Exercise> exercises = []) {
        new WorkoutPlanResponseDTO(
                id: plan.id,
                title: plan.title,
                description: plan.description,
                createdDate: plan.createdDate,
                duration: plan.duration,
                exercises: exercises.collect { exerciseMapper.toDTO(it) }
        )
    }

    List<WorkoutPlanResponseDTO> toDTOList(Iterable<WorkoutPlan> plans) {
        plans.collect { toDTO(it) }
    }
}
