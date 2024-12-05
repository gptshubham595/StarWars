package com.example.starwars.common.errorHandling

sealed class Failure(
    open val error: ErrorModel = ErrorModel(
        Exception("Unknown Error"), "000"
    )
) : IFailure {

    data class GenericException(
        override val error: ErrorModel = ErrorModel(Exception("Generic Error"), "400")
    ) : Failure()

    data class IOException(
        override val error: ErrorModel = ErrorModel(Exception("IO Error"), "403")
    ) : Failure()

    data class HttpException(
        override val error: ErrorModel = ErrorModel(Exception("Http Error"), "500")
    ) : Failure()
}