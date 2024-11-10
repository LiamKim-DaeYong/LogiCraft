package com.logicraft.common.exception

import com.logicraft.common.exception.base.BaseException
import com.logicraft.common.exception.base.ErrorCode

sealed class HttpException(
    errorCode: ErrorCode,
    message: String? = null,
) : BaseException(errorCode, message ?: errorCode.message) {
    class NotFoundException(message: String? = null) : HttpException(
        ErrorCode.NOT_FOUND,
        message,
    )

    class BadRequestException(message: String? = null) : HttpException(
        ErrorCode.BAD_REQUEST,
        message,
    )

    class ValidationException(
        message: String? = null,
        val details: List<String>? = null,
    ) : HttpException(
            ErrorCode.VALIDATION_ERROR,
            message,
        )

    class UnauthorizedException(message: String? = null) : HttpException(
        ErrorCode.UNAUTHORIZED,
        message,
    )

    class ForbiddenException(message: String? = null) : HttpException(
        ErrorCode.FORBIDDEN,
        message,
    )

    class ConflictException(message: String? = null) : HttpException(
        ErrorCode.CONFLICT,
        message,
    )

    class UnprocessableEntityException(message: String? = null) : HttpException(
        ErrorCode.UNPROCESSABLE_ENTITY,
        message,
    )
}
