package com.codeyuri.mappers


import com.codeyuri.domain.UserWorkoutPlan
import com.codeyuri.dtos.request.UserWorkoutPlanCreateDTO
import com.codeyuri.dtos.response.UserWorkoutPlanResponseDTO
import jakarta.inject.Singleton

@Singleton
class UserWorkoutMapper {

    UserWorkoutPlan toEntity(UserWorkoutPlanCreateDTO dto) {
        new UserWorkoutPlan(
                userId: dto.userId,
                workoutPlanId: dto.workoutPlanId,
                dateFrom: dto.dateFrom,
                dateTo: dto.dateTo
        )
    }

    UserWorkoutPlanResponseDTO toDTO(UserWorkoutPlan userWorkoutPlan) {
        new UserWorkoutPlanResponseDTO(
                id: userWorkoutPlan.id,
                workoutPlanId: userWorkoutPlan.workoutPlanId,
                dateTo: userWorkoutPlan.dateTo,
                dateFrom: userWorkoutPlan.dateFrom
        )
    }

    List<UserWorkoutPlanResponseDTO> toDTOList(Iterable<UserWorkoutPlan> workoutPlans) {
        workoutPlans.collect { toDTO(it) }
    }
}
