package com.codeyuri.mappers

import com.codeyuri.domain.WorkoutPlanDay
import com.codeyuri.dtos.request.WorkoutPlanDayCreateDTO
import com.codeyuri.dtos.response.WorkoutPlanDayResponseDTO
import jakarta.inject.Singleton

@Singleton
class WorkoutPlanDayMapper {

    WorkoutPlanDay toEntity(WorkoutPlanDayCreateDTO dto) {
        new WorkoutPlanDay(
                workoutPlanId: dto.workoutPlanId,
                dayOfWeek: dto.dayOfWeek
        )
    }

    WorkoutPlanDayResponseDTO toDTO(WorkoutPlanDay entity) {
        new WorkoutPlanDayResponseDTO(
                id: entity.id,
                workoutPlanId: entity.workoutPlanId,
                dayOfWeek: entity.dayOfWeek
        )
    }

    List<WorkoutPlanDayResponseDTO> toDTOList(Iterable<WorkoutPlanDay> list) {
        list.collect { toDTO(it) }
    }
}
