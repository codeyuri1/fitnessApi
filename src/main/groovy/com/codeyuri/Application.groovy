package com.codeyuri


import groovy.transform.CompileStatic
import io.micronaut.runtime.Micronaut
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.security.SecurityScheme

@OpenAPIDefinition(
        info = @Info(
                title = "Fitness API",
                version = "1.0",
                description = "API for managing users and training plans"
        ),
        security = @SecurityRequirement(name = "JWT")
)
@SecurityScheme(
        name = "JWT",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
)
//@Ro([
//        @RouterOperation(
//                path="/login",
//                method= HttpMethod.POST,
//                beanClass="io.micronaut.security.authentication.AuthenticationController",
//                beanMethod="login",
//                operation=@Operation(
//                        summary="Login",
//                        requestBody=@RequestBody(content=@Content(schema=@Schema(implementation= LoginCredentialsDTO))),
//                        responses=[
//                                @ApiResponse(responseCode="200",description="JWT", content=@Content(schema=@Schema(implementation= LoginResponseDTO))),
//                                @ApiResponse(responseCode="401",description="Unauthorized")
//                        ]
//                )
//        )
//])
@CompileStatic
class Application {

    static void main(String[] args) {
        Micronaut.run(Application, args)
    }
}
