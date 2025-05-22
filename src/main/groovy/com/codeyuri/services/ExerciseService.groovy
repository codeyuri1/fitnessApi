package com.codeyuri.services

import com.codeyuri.domain.Exercise
import com.codeyuri.dtos.request.ExerciseCreateDTO
import com.codeyuri.mappers.ExerciseMapper
import com.codeyuri.repository.ExerciseRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class ExerciseService {

    @Inject
    ExerciseRepository repository
    @Inject
    ExerciseMapper mapper

    Exercise save(ExerciseCreateDTO dto) {
        repository.save(mapper.toEntity(dto))
    }

    Optional<Exercise> findById(Long id) {
        repository.findById(id)
    }

    List<Exercise> findAll() {
        repository.findAll()
    }

    void delete(Long id) {
        repository.deleteById(id)
    }

    List<Exercise> findByMuscleGroup(String muscleGroup) {
        repository.findByMuscleGroup(muscleGroup)
    }
}
