package com.codeyuri.controller

import com.codeyuri.domain.User
import com.codeyuri.dtos.UserCreateDTO
import com.codeyuri.dtos.UserMapper
import com.codeyuri.dtos.UserResponseDTO
import com.codeyuri.dtos.UserUpdateDTO
import com.codeyuri.services.UserService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.inject.Inject
import jakarta.validation.Valid

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/users")
@Tag(name = "Users", description = "Operations related to user management")
class UserController {

    @Inject
    UserService service
    @Inject
    UserMapper mapper


    @Operation(summary = "Create a new user", description = "Creates and persists a user")
    @ApiResponse(responseCode = "201", description = "User created")
    @Post
    HttpResponse<UserResponseDTO> create(@Body @Valid UserCreateDTO dto) {
        User user = mapper.toEntity(dto)
        User saved = service.save(user)
        HttpResponse.created(mapper.toDTO(saved))
    }

    @Operation(summary = "Find user by ID")
    @ApiResponse(responseCode = "200", description = "User found")
    @Get("/{id}")
    User get(Long id) {
        service.findById(id)
                .map { HttpResponse.ok(mapper.toDTO(it)) }
                .orElse(HttpResponse.notFound())
    }

    @Operation(summary = "Find user by Email")
    @ApiResponse(responseCode = "200", description = "User found")
    @Get("/{email}")
    User getByEmail(String email) {
        mapper.toDTO(service.findByEmail(email).orElse(null))
    }

    @Operation(summary = "List all users")
    @ApiResponse(responseCode = "200", description = "List of users")
    @Get
    List<User> list() {
        mapper.toDTOList(service.findAll())
    }

    @Operation(summary = "Delete user by ID")
    @ApiResponse(responseCode = "204", description = "User deleted")
    @Delete("/{id}")
    HttpResponse<?> delete(Long id) {
        service.delete(id)
        HttpResponse.noContent()
    }

    @Put("/{id}")
    @Operation(summary = "Update an existing user")
    @ApiResponse(responseCode = "200", description = "User updated")
    HttpResponse<UserResponseDTO> update(Long id, @Body @Valid UserUpdateDTO dto) {
        User updated = service.update(id, dto)
        HttpResponse.ok(mapper.toDTO(updated))
    }
}
