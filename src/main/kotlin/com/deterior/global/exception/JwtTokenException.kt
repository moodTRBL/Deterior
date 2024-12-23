package com.deterior.global.exception

open class JwtTokenException(
    override val message: String,
    override val value: String,
    override val errorCode: ErrorCode
) : DesplayApplicationException(message = message, value = value, errorCode = errorCode)

class InConsistentJwtTokenException(
    override val message: String,
    override val value: String,
    override val errorCode: ErrorCode
) : JwtTokenException(message = message, value = value, errorCode = errorCode)

class InvalidJwtTokenException(
    override val message: String,
    override val value: String,
    override val errorCode: ErrorCode
) : JwtTokenException(message = message, value = value, errorCode = errorCode)