package com.codeyuri.controller

import com.codeyuri.dtos.request.WorkoutPlanExerciseDTO
import com.codeyuri.mappers.WorkoutPlanExerciseMapper
import com.codeyuri.services.WorkoutPlanExerciseService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.inject.Inject
import jakarta.validation.Valid

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/workout-plan-exercises")
@Tag(name = "Workout Plan Exercises", description = "Manage exercises in workout plans")
class WorkoutPlanExerciseController {

    final WorkoutPlanExerciseService service
    final WorkoutPlanExerciseMapper mapper

    WorkoutPlanExerciseController(WorkoutPlanExerciseService service, WorkoutPlanExerciseMapper mapper) {
        this.service = service
        this.mapper = mapper
    }

    @Post
    @Operation(summary = "Add exercise to workout plan")
    HttpResponse<WorkoutPlanExerciseDTO> add(@Body @Valid WorkoutPlanExerciseDTO dto) {
        def saved = service.save(mapper.toEntity(dto))
        HttpResponse.created(mapper.toDTO(saved))
    }

    @Get("/{planId}")
    @Operation(summary = "List exercises by workout plan ID")
    List<WorkoutPlanExerciseDTO> list(Long planId) {
        mapper.toDTOList(service.findByWorkoutPlanId(planId))
    }

    @Delete("/{id}")
    @Operation(summary = "Remove exercise from workout plan")
    HttpResponse<?> delete(Long id) {
        service.delete(id)
        HttpResponse.noContent()
    }
}