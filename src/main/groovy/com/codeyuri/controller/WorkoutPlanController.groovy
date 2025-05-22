package com.codeyuri.controller

import com.codeyuri.dtos.request.WorkoutPlanCreateDTO
import com.codeyuri.dtos.response.WorkoutPlanResponseDTO
import com.codeyuri.mappers.WorkoutPlanMapper
import com.codeyuri.services.WorkoutPlanService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.QueryValue
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.inject.Inject
import jakarta.validation.Valid

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/workout-plans")
@Tag(name = "Workout Plans", description = "Operations related to workout plans")
class WorkoutPlanController {

    final WorkoutPlanService service
    final WorkoutPlanMapper mapper

    WorkoutPlanController(WorkoutPlanService service, WorkoutPlanMapper mapper) {
        this.service = service
        this.mapper = mapper
    }


    @Post
    @Operation(summary = "Create a new workout plan")
    @ApiResponse(responseCode = "201", description = "Workout plan created")
    HttpResponse<WorkoutPlanResponseDTO> create(@Body @Valid WorkoutPlanCreateDTO dto) {
        def saved = service.save(dto)
        HttpResponse.created(mapper.toDTO(saved))
    }

    @Get("/{id}")
    @Operation(summary = "Get workout plan by ID")
    HttpResponse<WorkoutPlanResponseDTO> get(Long id) {
        service.findById(id)
                .map { HttpResponse.ok(mapper.toDTO(it)) }
                .orElse(HttpResponse.notFound())
    }

    @Get
    @Operation(summary = "List all workout plans")
    List<WorkoutPlanResponseDTO> list() {
        mapper.toDTOList(service.findAll())
    }

    @Get("/search{?title}")
    @Operation(summary = "Find workout plans by title")
    List<WorkoutPlanResponseDTO> search(@QueryValue String title) {
        mapper.toDTOList(service.findByTitleLike(title))
    }

    @Delete("/{id}")
    @Operation(summary = "Delete workout plan by ID")
    @ApiResponse(responseCode = "204", description = "Workout plan deleted")
    HttpResponse<?> delete(Long id) {
        service.delete(id)
        HttpResponse.noContent()
    }
}