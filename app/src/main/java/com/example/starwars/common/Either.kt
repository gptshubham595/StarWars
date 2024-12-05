package com.example.starwars.common

import com.example.starwars.common.errorHandling.IFailure

sealed class Either<out Failure, out Success> where Failure : IFailure {
    data class Error<out Failure : IFailure>(val exception: Failure) : Either<Failure, Nothing>()
    data class Success<out Success>(val data: Success) : Either<Nothing, Success>()
}