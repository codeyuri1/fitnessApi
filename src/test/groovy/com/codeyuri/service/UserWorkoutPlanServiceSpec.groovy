package com.codeyuri.service

import com.codeyuri.domain.Exercise
import com.codeyuri.domain.UserWorkoutPlan
import com.codeyuri.domain.WorkoutPlan
import com.codeyuri.domain.WorkoutPlanExercise
import com.codeyuri.repository.ExerciseRepository
import com.codeyuri.repository.UserWorkoutPlanRepository
import com.codeyuri.repository.WorkoutPlanExerciseRepository
import com.codeyuri.repository.WorkoutPlanRepository
import com.codeyuri.services.UserWorkoutPlanService
import groovy.util.logging.Slf4j
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

import java.time.LocalDate

@MicronautTest
@Slf4j
class UserWorkoutPlanServiceSpec extends Specification {

    @Inject
    UserWorkoutPlanRepository userWorkoutPlanRepository

    @Inject
    WorkoutPlanRepository workoutPlanRepository

    @Inject
    WorkoutPlanExerciseRepository workoutPlanExerciseRepository

    @Inject
    ExerciseRepository exerciseRepository

    @Inject
    UserWorkoutPlanService userWorkoutPlanService


    def "should return actual workout plan for user"() {
        given:
        def exercise = exerciseRepository.save(new Exercise(
                name: "Push-up",
                description: "Chest workout",
                muscleGroup: "CHEST",
                difficulty: "BEGINNER",
                duration: 10
        ))

        def plan = workoutPlanRepository.save(new WorkoutPlan(
                title: "Full Body Plan",
                description: "All-in-one",
                createdDate: LocalDate.now(),
                duration: 30
        ))

        workoutPlanExerciseRepository.save(new WorkoutPlanExercise(
                workoutPlanId: plan.id,
                exerciseId: exercise.id,
                sequence: 1,
                sets: 3,
                reps: 12
        ))

        userWorkoutPlanRepository.save(new UserWorkoutPlan(
                userId: 99L,
                workoutPlanId: plan.id,
                dateFrom: LocalDate.now().minusDays(1),
                dateTo: LocalDate.now().plusDays(5)
        ))

        when:
        def workout = userWorkoutPlanService.getUserActualWorkoutPlan(99L)

        then:
        workout != null
        workout.title == "Full Body Plan"
        workout.exercises.size() == 1
        workout.exercises[0].exercise.name == "Push-up"
    }

}
