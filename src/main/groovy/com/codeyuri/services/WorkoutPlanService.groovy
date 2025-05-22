package com.codeyuri.services

import com.codeyuri.domain.WorkoutPlan
import com.codeyuri.dtos.request.WorkoutPlanCreateDTO
import com.codeyuri.mappers.WorkoutPlanMapper
import com.codeyuri.repository.WorkoutPlanRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class WorkoutPlanService {

    @Inject WorkoutPlanRepository repository
    @Inject WorkoutPlanMapper mapper

    WorkoutPlan save(WorkoutPlanCreateDTO dto) {
        repository.save(mapper.toEntity(dto))
    }

    Optional<WorkoutPlan> findById(Long id) {
        repository.findById(id)
    }

    List<WorkoutPlan> findAll() {
        repository.findAll()
    }

    void delete(Long id) {
        repository.deleteById(id)
    }

    List<WorkoutPlan> findByTitleLike(String title) {
        repository.findByTitleLike("%${title}%")
    }
}
