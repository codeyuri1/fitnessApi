package com.codeyuri.controller

import com.codeyuri.domain.User
import com.codeyuri.dtos.request.UserCreateDTO
import com.codeyuri.mappers.UserMapper
import com.codeyuri.dtos.response.UserResponseDTO
import com.codeyuri.dtos.request.UserUpdateDTO
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

    @Post
    @Operation(summary = "Create a new user", description = "Creates and persists a user")
    @ApiResponse(responseCode = "201", description = "User created")
    HttpResponse<UserResponseDTO> create(@Body @Valid UserCreateDTO dto) {
        User saved = service.save(mapper.toEntity(dto))
        return HttpResponse.created(mapper.toDTO(saved))
    }

    @Get("/{id}")
    @Operation(summary = "Find user by ID")
    @ApiResponse(responseCode = "200", description = "User found")
    HttpResponse<UserResponseDTO> getById(Long id) {
        return service.findById(id)
                .map(user -> HttpResponse.ok(mapper.toDTO(user)))
                .orElse(HttpResponse.notFound())
    }

    @Get("/{email}")
    @Operation(summary = "Find user by Email")
    @ApiResponse(responseCode = "200", description = "User found")
    HttpResponse<UserResponseDTO> getByEmail(String email) {
        return service.findByEmail(email)
                .map(user -> HttpResponse.ok(mapper.toDTO(user)))
                .orElse(HttpResponse.notFound())
    }

    @Get
    @Operation(summary = "List all users")
    @ApiResponse(responseCode = "200", description = "List of users")
    List<UserResponseDTO> list() {
        return mapper.toDTOList(service.findAll())
    }

    @Delete("/{id}")
    @Operation(summary = "Delete user by ID")
    @ApiResponse(responseCode = "204", description = "User deleted")
    HttpResponse<?> delete(Long id) {
        service.delete(id)
        return HttpResponse.noContent()
    }

    @Put("/{id}")
    @Operation(summary = "Update an existing user")
    @ApiResponse(responseCode = "200", description = "User updated")
    HttpResponse<UserResponseDTO> update(Long id, @Body @Valid UserUpdateDTO dto) {
        User updated = service.update(id, dto)
        return HttpResponse.ok(mapper.toDTO(updated))
    }
}
