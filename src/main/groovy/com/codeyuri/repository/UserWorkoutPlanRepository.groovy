package com.codeyuri.repository

import com.codeyuri.domain.UserWorkoutPlan
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

import java.time.LocalDate
import java.time.LocalDateTime

@Repository
interface UserWorkoutPlanRepository extends CrudRepository<UserWorkoutPlan, Long> {

    List<UserWorkoutPlan> findAllByUserId(Long userId)

    Optional<UserWorkoutPlan> findByUserIdAndDateToAfter(Long userId, LocalDate date )

}