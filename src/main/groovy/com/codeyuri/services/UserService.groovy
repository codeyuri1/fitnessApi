package com.codeyuri.services

import com.codeyuri.domain.User
import com.codeyuri.dtos.UserMapper
import com.codeyuri.dtos.UserUpdateDTO
import com.codeyuri.repository.UserRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class UserService {

    @Inject
    UserRepository repository

    @Inject UserMapper mapper


    User save(User user) {
        repository.save(user)
    }

    Optional<User> findById(Long id) {
        repository.findById(id)
    }

    List<User> findAll() {
        repository.findAll().toList()
    }

    void delete(Long id) {
        repository.deleteById(id)
    }

    Optional<User> findByEmail(String email) {
        repository.findByEmail(email)
    }

    User update(Long id, UserUpdateDTO dto) {
        User user = repository.findById(id)
                .orElseThrow { new NoSuchElementException("User not found: $id") }
        mapper.updateEntity(dto, user)
        return repository.save(user)
    }
}
