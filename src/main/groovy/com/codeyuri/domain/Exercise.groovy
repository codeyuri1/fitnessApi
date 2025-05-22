package com.codeyuri.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class Exercise {

    @Id
    @GeneratedValue
    Long id

    @Column(nullable = false)
    String name

    String description

    @Column(nullable = false)
    String muscleGroup

    @Column(nullable = false)
    String difficulty

    Integer duration
}
