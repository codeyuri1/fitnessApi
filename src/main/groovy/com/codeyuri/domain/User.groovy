package com.codeyuri.domain

import io.micronaut.core.annotation.Introspected
import io.micronaut.data.annotation.MappedEntity
import jakarta.persistence.*

import java.time.LocalDate

@Introspected
@Entity
@Table(name = "UserController", indexes = [
        @Index(name = "idx_user_name", columnList = "name"),
        @Index(name = "idx_user_email", columnList = "email")

])
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    @Column(nullable = false)
    String name

    @Column(unique = true, nullable = false, length = 100)
    String email

    @Column(name = "birth_date")
    LocalDate birthDate


    @Column(nullable = false)
    Double weight

    @Column(nullable = false)
    Double height
}
