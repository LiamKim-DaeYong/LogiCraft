package com.logicraft.common.exception

import com.logicraft.common.exception.base.BaseException
import com.logicraft.common.exception.base.ErrorCode
import kotlin.reflect.KClass

sealed class DomainException(
    errorCode: ErrorCode,
    message: String? = null,
    cause: Throwable? = null,
) : BaseException(errorCode, message ?: errorCode.message, cause) {

    class NotFoundException(
        entityClass: KClass<*>,
        identifier: String,
    ) : DomainException(
        ErrorCode.NOT_FOUND,
        message = "${entityClass.simpleName} with identifier $identifier not found"
    )

    class InvalidStateException(
        entityClass: KClass<*>,
        identifier: String,
        currentState: Enum<*>,
        expectedState: Enum<*>? = null,
    ) : DomainException(
        ErrorCode.BAD_REQUEST,
        message = """
            ${entityClass.simpleName} with identifier $identifier is in an invalid state: $currentState
            ${expectedState?.let { "Expected state: $it" } ?: ""}
        """.trimIndent()
    )
}
