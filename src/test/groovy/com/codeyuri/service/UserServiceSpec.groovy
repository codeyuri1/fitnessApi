package com.codeyuri.service

import com.codeyuri.domain.User
import com.codeyuri.services.UserService
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

import java.time.LocalDate

@MicronautTest
class UserServiceSpec extends Specification {

    @Inject
    UserService userService

    def "should save a valid user"() {
        given:
        def user = new User(
                name: "Yuri Martins",
                email: "yuri@email.com",
                birthDate: LocalDate.of(1997, 7, 15),
                weight: 75.0,
                height: 1.78
        )

        when:
        def saved = userService.save(user)

        then:
        saved.id != null
        saved.email == "yuri@email.com"
    }
}
