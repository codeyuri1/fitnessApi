package com.codeyuri.controller


import com.codeyuri.services.UserWorkoutPlanService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/user-workout-plans")
@Tag(name = "User Workout Plans", description = "User-specific workout plan operations")
class UserWorkoutPlanController {

    private final UserWorkoutPlanService userWorkoutPlanService

    UserWorkoutPlanController(UserWorkoutPlanService userWorkoutPlanService) {
        this.userWorkoutPlanService = userWorkoutPlanService
    }

    @Get("/{userId}/actual")
    @Operation(summary = "Get actual workout plan for a user")
    @ApiResponse(responseCode = "200", description = "Actual workout plan retrieved")
    @ApiResponse(responseCode = "404", description = "No active workout plan found")
    HttpResponse<?> getActualWorkoutPlan(Long userId) {
        def result = userWorkoutPlanService.getUserActualWorkoutPlan(userId)

        if (result) {
            return HttpResponse.ok(result)
        } else {
            return HttpResponse.notFound()
        }
    }
}
