package com.codeyuri.controller

import com.codeyuri.dtos.request.WorkoutPlanExerciseDTO
import com.codeyuri.dtos.response.WorkoutPlanExerciseResponseDTO
import com.codeyuri.mappers.WorkoutPlanExerciseMapper
import com.codeyuri.services.WorkoutPlanDayService
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

import java.time.DayOfWeek
import java.time.LocalDate

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/workout-plan-exercises")
@Tag(name = "Workout Plan Exercises", description = "Manage exercises in workout plans")
class WorkoutPlanExerciseController {

    final WorkoutPlanExerciseService service
    final WorkoutPlanExerciseMapper mapper
    final WorkoutPlanDayService dayService

    WorkoutPlanExerciseController(WorkoutPlanExerciseService service, WorkoutPlanExerciseMapper mapper) {
        this.service = service
        this.mapper = mapper
    }

    @Post
    @Operation(summary = "Add exercise to workout plan")
    HttpResponse<WorkoutPlanExerciseResponseDTO> add(@Body @Valid WorkoutPlanExerciseDTO dto) {
        def saved = service.save(mapper.toEntity(dto))
        HttpResponse.created(mapper.toDTO(saved))
    }

    @Get("/{planId}")
    @Operation(summary = "List exercises by workout plan ID")
    List<WorkoutPlanExerciseResponseDTO> list(Long planId) {
        mapper.toDTOList(service.findByWorkoutPlanId(planId))
    }

    @Delete("/{id}")
    @Operation(summary = "Remove exercise from workout plan")
    HttpResponse<?> delete(Long id) {
        service.delete(id)
        HttpResponse.noContent()
    }

    @Get("/days/{dayId}/exercises")
    @Operation(summary = "Get exercises for a specific day in the plan")
    List<WorkoutPlanExerciseResponseDTO> getExercisesByDay(Long planId, Long dayId) {
        def exercises = service.findByWorkoutPlanDayId(dayId)
        mapper.toDTOList(exercises)
    }

    @Get("/today")
    @Operation(summary = "Get today's workout for the plan")
    HttpResponse<List<WorkoutPlanExerciseResponseDTO>> getTodayWorkout(Long planId) {
        def today = DayOfWeek.from(LocalDate.now())

        def optionalDay = dayService.findByWorkoutPlanIdAndDayOfWeek(planId, today)

        if (optionalDay.isEmpty()) {
            return HttpResponse.ok([])  // ou HttpResponse.notFound() se quiser
        }

        def exercises = service.findByWorkoutPlanDayId(optionalDay.get().id)
        HttpResponse.ok(mapper.toDTOList(exercises))
    }
}