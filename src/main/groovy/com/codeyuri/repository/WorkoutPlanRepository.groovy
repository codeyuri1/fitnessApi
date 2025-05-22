package com.codeyuri.repository

import com.codeyuri.domain.WorkoutPlan
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface WorkoutPlanRepository extends CrudRepository<WorkoutPlan, Long> {
    List<WorkoutPlan> findByTitleLike(String title)

}