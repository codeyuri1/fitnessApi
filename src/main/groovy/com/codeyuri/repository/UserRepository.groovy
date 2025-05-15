package com.codeyuri.repository

import com.codeyuri.domain.User
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email)
}
