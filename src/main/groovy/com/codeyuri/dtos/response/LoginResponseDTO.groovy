package com.codeyuri.dtos.response

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable
import io.swagger.v3.oas.annotations.media.Schema

@Serdeable
@Introspected
class LoginResponseDTO {
    @Schema(description = "O token JWT", example="eyJh…")
    String access_token
    String token_type
    Integer expires_in
}
