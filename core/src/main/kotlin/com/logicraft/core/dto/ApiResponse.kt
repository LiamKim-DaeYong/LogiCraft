package com.logicraft.core.dto

import org.springframework.http.HttpStatus
import java.time.Instant

data class ApiResponse<T>(
    val status: HttpStatus,
    val code: Int,
    val message: String?,
    val data: T?,
    val timestamp: String = Instant.now().toString()
) {
    companion object {
        fun <T> success(data: T? = null, message: String = "Operation successful"): ApiResponse<T> {
            return ApiResponse(
                status = HttpStatus.OK,
                code = HttpStatus.OK.value(),
                message = message,
                data = data
            )
        }

        fun <T> created(data: T? = null, message: String = "Resource created successfully"): ApiResponse<T> {
            return ApiResponse(
                status = HttpStatus.CREATED,
                code = HttpStatus.CREATED.value(),
                message = message,
                data = data
            )
        }

        fun <T> badRequest(message: String, data: T? = null): ApiResponse<T> {
            return ApiResponse(
                status = HttpStatus.BAD_REQUEST,
                code = HttpStatus.BAD_REQUEST.value(),
                message = message,
                data = data
            )
        }

        fun <T> internalServerError(message: String, data: T? = null): ApiResponse<T> {
            return ApiResponse(
                status = HttpStatus.INTERNAL_SERVER_ERROR,
                code = HttpStatus.INTERNAL_SERVER_ERROR.value(),
                message = message,
                data = data
            )
        }
    }
}