package com.logicraft.common.exception.base

import org.springframework.http.HttpStatus

enum class ErrorCode(val message: String, val status: HttpStatus) {
    NOT_FOUND("Resource not found", HttpStatus.NOT_FOUND),
    BAD_REQUEST("Invalid request data", HttpStatus.BAD_REQUEST),
    VALIDATION_ERROR("Validation error", HttpStatus.BAD_REQUEST),
    UNAUTHORIZED("Authentication required", HttpStatus.UNAUTHORIZED),
    FORBIDDEN("Access denied", HttpStatus.FORBIDDEN),
    CONFLICT("Resource conflict", HttpStatus.CONFLICT),
    UNPROCESSABLE_ENTITY("Cannot process the request", HttpStatus.UNPROCESSABLE_ENTITY),
    SERVICE_UNAVAILABLE("Service is unavailable", HttpStatus.SERVICE_UNAVAILABLE),
    TIMEOUT("Request timed out", HttpStatus.REQUEST_TIMEOUT),
    CIRCUIT_BREAKER("Circuit breaker is open", HttpStatus.SERVICE_UNAVAILABLE),
    DEPENDENCY_FAILURE("Dependency failure occurred", HttpStatus.BAD_GATEWAY),
    MISSING_CORRELATION_ID("Missing correlationId", HttpStatus.BAD_REQUEST),
}
