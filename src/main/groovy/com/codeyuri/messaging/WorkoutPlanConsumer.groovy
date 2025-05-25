package com.codeyuri.messaging

import com.codeyuri.events.WorkoutPlanCreatedEvent
import groovy.util.logging.Slf4j
import io.micronaut.rabbitmq.annotation.Queue
import io.micronaut.rabbitmq.annotation.RabbitListener

@RabbitListener
@Slf4j
class WorkoutPlanConsumer {

    @Queue("workout.plan.created")
    void onWorkoutPlanCreated(WorkoutPlanCreatedEvent event) {
        log.info("Received event: Workout Plan '${event.title}' created for User ID ${event.userId}")
        //TODO Aqui pode chamar serviço de notificação, envio de e-mail, etc.
    }
}
