package com.codeyuri.messaging

import com.codeyuri.events.WorkoutPlanCreatedEvent
import io.micronaut.rabbitmq.annotation.Binding
import io.micronaut.rabbitmq.annotation.RabbitClient

@RabbitClient("fitness")
interface WorkoutPlanPublisher {

    @Binding("workout.plan.created")
    void publish(WorkoutPlanCreatedEvent event)
}
