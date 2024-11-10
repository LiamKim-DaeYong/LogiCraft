package com.logicraft.common.exception

import com.logicraft.common.exception.base.BaseException
import com.logicraft.common.response.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(BaseException::class)
    fun handleBaseException(ex: BaseException): ResponseEntity<ApiResponse<Any>> {
        val errorResponse =
            ApiResponse.error<Any>(
                status = ex.httpStatus,
                code = ex.httpStatus.value(),
                message = ex.message,
                errorDetails = if (ex is HttpException.ValidationException) ex.details else null,
            )

        return ResponseEntity.status(ex.httpStatus).body(errorResponse)
    }
}
