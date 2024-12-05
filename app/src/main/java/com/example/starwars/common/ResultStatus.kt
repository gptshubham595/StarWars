package com.example.starwars.common

sealed class ResultStatus<out Result, out Error> {
    data object Loading : ResultStatus<Nothing, Nothing>()
    data class Success<out Result>(val result: Result) : ResultStatus<Result, Nothing>()
    data class Error<out Error>(val error: Error) : ResultStatus<Nothing, Error>()
}
