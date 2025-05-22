package com.codeyuri.mappers

import com.codeyuri.domain.User
import com.codeyuri.dtos.request.UserCreateDTO
import com.codeyuri.dtos.request.UserUpdateDTO
import com.codeyuri.dtos.response.UserResponseDTO
import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable
import jakarta.inject.Singleton

@Introspected
@Singleton
@Serdeable
class UserMapper {

    void updateEntity(UserUpdateDTO dto, User user) {
        user.name = dto.name
        user.email = dto.email
        user.birthDate = dto.birthDate
        user.weight = dto.weight
        user.height = dto.height
    }

    User toEntity(UserCreateDTO dto) {
        new User(
                name: dto.name,
                email: dto.email,
                birthDate: dto.birthDate,
                weight: dto.weight,
                height: dto.height
        )
    }

    UserResponseDTO toDTO(User user) {
        new UserResponseDTO(
                id: user.id,
                name: user.name,
                email: user.email,
                birthDate: user.birthDate,
                weight: user.weight,
                height: user.height
        )
    }

    List<UserResponseDTO> toDTOList(Iterable<User> users) {
        users.collect { toDTO(it) }
    }
}
