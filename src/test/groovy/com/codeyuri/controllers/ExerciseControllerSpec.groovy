package com.codeyuri.controllers

import com.codeyuri.dtos.request.ExerciseCreateDTO
import com.codeyuri.repository.ExerciseRepository
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

@MicronautTest
class ExerciseControllerSpec extends Specification {

    @Inject
    ExerciseRepository repository

    @Inject
    HttpClient client

    def "should create and retrieve exercise"() {
        given:
        def dto = new ExerciseCreateDTO(
                name: "Push-up",
                description: "Upper body exercise",
                muscleGroup: "CHEST",
                difficulty: "BEGINNER",
                duration: 10
        )

        when: "Creating a new exercise"
        def request = HttpRequest.POST("/exercises", dto)
        def response = client.toBlocking().exchange(request, Map)

        then: "Response is CREATED"
        response.status == HttpStatus.CREATED
        response.body().name == "Push-up"

        and: "Exercise is retrievable"
        def id = response.body().id
        def getResponse = client.toBlocking().retrieve("/exercises/${id}", Map)

        getResponse.name == "Push-up"
        getResponse.muscleGroup == "CHEST"
    }
}
