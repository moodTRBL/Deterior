package com.deterior.global.exception

open class AuthenticationFailException(
    override val message: String,
    open val value: String,
    open val errorCode: ErrorCode
) : RuntimeException()

class EmailAuthenticationFailException(
    override val value: String,
    override val message: String,
    override val errorCode: ErrorCode
) : AuthenticationFailException(message = message, value = value, errorCode = errorCode)