package com.example.starwars.common

import com.example.starwars.common.errorHandling.Failure
import com.example.starwars.common.errorHandling.IFailure
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

interface BaseUseCase<in Param, out Result> where Result : Any? {
    suspend fun run(params: Param): Either<IFailure, Result>

    operator fun invoke(
        scope: CoroutineScope = CoroutineScope(Dispatchers.IO),
        params: Param,
        onSuccess: (Result) -> Unit = {},
        onFailure: (IFailure) -> Unit = {}
    ) {
        scope.launch {
            val job = async { run(params) }

            when (val result = job.await()) {
                is Either.Success -> onSuccess(result.data)
                is Either.Error -> onFailure(result.exception)
            }
        }
    }
}