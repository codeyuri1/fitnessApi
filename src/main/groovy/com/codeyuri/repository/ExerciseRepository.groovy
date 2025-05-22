package com.codeyuri.repository

import com.codeyuri.domain.Exercise
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface ExerciseRepository extends CrudRepository<Exercise, Long> {

    List<Exercise> findByMuscleGroup(String muscleGroup)




}