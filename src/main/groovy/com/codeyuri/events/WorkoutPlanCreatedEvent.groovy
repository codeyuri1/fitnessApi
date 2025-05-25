package com.codeyuri.events

import io.micronaut.serde.annotation.Serdeable

@Serdeable
class WorkoutPlanCreatedEvent {
    Long workoutPlanId
    Long userId
    String title
}
