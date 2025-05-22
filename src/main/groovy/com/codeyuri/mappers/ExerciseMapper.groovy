package com.codeyuri.mappers

import com.codeyuri.domain.Exercise
import com.codeyuri.dtos.request.ExerciseCreateDTO
import com.codeyuri.dtos.response.ExerciseResponseDTO
import io.micronaut.serde.annotation.Serdeable
import jakarta.inject.Singleton

@Singleton
@Serdeable
class ExerciseMapper {


    Exercise toEntity(ExerciseCreateDTO dto) {
        new Exercise(
                name: dto.name,
                description: dto.description,
                muscleGroup: dto.muscleGroup,
                difficulty: dto.difficulty,
                duration: dto.duration
        )
    }

    ExerciseResponseDTO toDTO(Exercise exercise) {
        new ExerciseResponseDTO(
                id: exercise.id,
                name: exercise.name,
                description: exercise.description,
                muscleGroup: exercise.muscleGroup,
                difficulty: exercise.difficulty,
                duration: exercise.duration
        )
    }

    List<ExerciseResponseDTO> toDTOList(Iterable<Exercise> exercises) {
        exercises.collect { toDTO(it) }
    }
}
