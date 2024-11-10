package com.logicraft.common.exception

import com.logicraft.common.exception.base.BaseException
import com.logicraft.common.exception.base.ErrorCode

sealed class InfrastructureException(
    errorCode: ErrorCode,
    message: String? = null,
    cause: Throwable? = null,
) : BaseException(errorCode, message ?: errorCode.message, cause) {
    class EventPublishingException(
        message: String,
        cause: Throwable? = null,
    ) : InfrastructureException(ErrorCode.DEPENDENCY_FAILURE, message, cause)

    class MissingCorrelationIdException(
        message: String,
        cause: Throwable? = null,
    ) : InfrastructureException(ErrorCode.MISSING_CORRELATION_ID, message, cause)

    class CallbackTimeoutException(
        message: String,
        cause: Throwable? = null,
    ) : InfrastructureException(ErrorCode.TIMEOUT, message, cause)
}
