package com.codeyuri.controller


import com.codeyuri.dtos.request.WorkoutPlanDayCreateDTO
import com.codeyuri.dtos.response.WorkoutPlanDayResponseDTO
import com.codeyuri.mappers.WorkoutPlanDayMapper
import com.codeyuri.repository.WorkoutPlanDayRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.inject.Inject

@Tag(name = "Workout Plan Days")
@Controller("/workout-plans/{planId}/days")
class WorkoutPlanDayController {

    @Inject
    WorkoutPlanDayRepository repository

    @Inject
    WorkoutPlanDayMapper mapper

    @Post
    HttpResponse<WorkoutPlanDayResponseDTO> create(@PathVariable Long planId,
                                                   @Body WorkoutPlanDayCreateDTO dto) {
        dto.workoutPlanId = planId
        def saved = repository.save(mapper.toEntity(dto))
        HttpResponse.created(mapper.toDTO(saved))
    }

    @Get
    List<WorkoutPlanDayResponseDTO> list(@PathVariable Long planId) {
        mapper.toDTOList(repository.findByWorkoutPlanId(planId))
    }
}
