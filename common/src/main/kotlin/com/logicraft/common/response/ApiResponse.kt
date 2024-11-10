package com.logicraft.common.response

import org.springframework.http.HttpStatus
import java.time.Instant

data class ApiResponse<T>(
    val status: HttpStatus,
    val code: Int,
    val message: String?,
    val data: T?,
    val timestamp: String = Instant.now().toString(),
    val meta: Map<String, Any>? = null,
    val errorDetails: List<String>? = null,
) {
    companion object {
        fun <T> success(
            data: T? = null,
            message: String = "Operation successful",
            meta: Map<String, Any>? = null,
        ): ApiResponse<T> {
            return ApiResponse(
                status = HttpStatus.OK,
                code = HttpStatus.OK.value(),
                message = message,
                data = data,
                meta = meta,
            )
        }

        fun <T> created(
            data: T? = null,
            message: String = "Resource created successfully",
            meta: Map<String, Any>? = null,
        ): ApiResponse<T> {
            return ApiResponse(
                status = HttpStatus.CREATED,
                code = HttpStatus.CREATED.value(),
                message = message,
                data = data,
                meta = meta,
            )
        }

        fun <T> badRequest(
            message: String,
            data: T? = null,
            meta: Map<String, Any>? = null,
            errorDetails: List<String>? = null,
        ): ApiResponse<T> {
            return ApiResponse(
                status = HttpStatus.BAD_REQUEST,
                code = HttpStatus.BAD_REQUEST.value(),
                message = message,
                data = data,
                meta = meta,
                errorDetails = errorDetails,
            )
        }

        fun <T> internalServerError(
            message: String,
            data: T? = null,
            meta: Map<String, Any>? = null,
            errorDetails: List<String>? = null,
        ): ApiResponse<T> {
            return ApiResponse(
                status = HttpStatus.INTERNAL_SERVER_ERROR,
                code = HttpStatus.INTERNAL_SERVER_ERROR.value(),
                message = message,
                data = data,
                meta = meta,
                errorDetails = errorDetails,
            )
        }

        fun <T> error(
            status: HttpStatus,
            code: Int,
            message: String,
            data: T? = null,
            meta: Map<String, Any>? = null,
            errorDetails: List<String>? = null,
        ): ApiResponse<T> {
            return ApiResponse(
                status = status,
                code = code,
                message = message,
                data = data,
                meta = meta,
                errorDetails = errorDetails,
            )
        }
    }
}
