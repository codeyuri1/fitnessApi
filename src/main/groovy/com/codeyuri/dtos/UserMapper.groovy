package com.codeyuri.dtos

import com.codeyuri.domain.User
import io.micronaut.core.annotation.Introspected

@Introspected
class UserMapper {

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
