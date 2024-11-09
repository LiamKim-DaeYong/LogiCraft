package com.logicraft.common.exception.base

import org.springframework.http.HttpStatus

open class BaseException(
    private val errorCode: ErrorCode,
    override val message: String = errorCode.message,
    override val cause: Throwable? = null,
    val httpStatus: HttpStatus = errorCode.status,
) : RuntimeException(message, cause)