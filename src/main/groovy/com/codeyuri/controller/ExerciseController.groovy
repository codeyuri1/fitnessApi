package com.codeyuri.controller

import com.codeyuri.dtos.request.ExerciseCreateDTO
import com.codeyuri.dtos.response.ExerciseResponseDTO
import com.codeyuri.mappers.ExerciseMapper
import com.codeyuri.services.ExerciseService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/exercises")
@Tag(name = "Exercises", description = "Operations related to exercises")
class ExerciseController {

    final ExerciseService service
    final ExerciseMapper mapper

    ExerciseController(ExerciseService service, ExerciseMapper mapper) {
        this.service = service
        this.mapper = mapper
    }

    @Post
    @Operation(summary = "Create a new exercise")
    @ApiResponse(responseCode = "201", description = "Exercise created")
    HttpResponse<ExerciseResponseDTO> create(@Body @Valid ExerciseCreateDTO dto) {
        def saved = service.save(dto)
        HttpResponse.created(mapper.toDTO(saved))
    }

    @Get("/{id}")
    @Operation(summary = "Get exercise by ID")
    HttpResponse<ExerciseResponseDTO> get(Long id) {
        service.findById(id)
                .map { HttpResponse.ok(mapper.toDTO(it)) }
                .orElse(HttpResponse.notFound())
    }

    @Get
    @Operation(summary = "List all exercises")
    List<ExerciseResponseDTO> list() {
        mapper.toDTOList(service.findAll())
    }

    @Get("/muscle-group/{group}")
    @Operation(summary = "Find exercises by muscle group")
    List<ExerciseResponseDTO> byMuscleGroup(String group) {
        mapper.toDTOList(service.findByMuscleGroup(group))
    }

    @Delete("/{id}")
    @Operation(summary = "Delete exercise by ID")
    @ApiResponse(responseCode = "204", description = "Exercise deleted")
    HttpResponse<?> delete(Long id) {
        service.delete(id)
        HttpResponse.noContent()
    }
}