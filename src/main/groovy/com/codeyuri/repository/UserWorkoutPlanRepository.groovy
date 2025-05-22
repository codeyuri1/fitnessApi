package com.codeyuri.repository


import com.codeyuri.domain.UserWorkoutPlan
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface UserWorkoutPlanRepository extends CrudRepository<UserWorkoutPlan, Long> {

    List<UserWorkoutPlan> findAllByUserId(Long userId)

}