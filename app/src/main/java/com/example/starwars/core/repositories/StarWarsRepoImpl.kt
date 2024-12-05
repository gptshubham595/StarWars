package com.example.starwars.core.repositories

import com.example.starwars.common.Either
import com.example.starwars.common.errorHandling.ErrorModel
import com.example.starwars.common.errorHandling.Failure
import com.example.starwars.common.errorHandling.IFailure
import com.example.starwars.core.data.datasource.network.StarWarsApiService
import com.example.starwars.core.domain.models.VehicleData
import com.example.starwars.core.domain.repositories.StartWarsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class StarWarsRepoImpl @Inject constructor(
    private val starWarsApi: StarWarsApiService
) : StartWarsRepository {
    override suspend fun getStarWarsVehicleList(): Either<IFailure, Flow<List<VehicleData>>> {
        return try {
            Either.Success(flow {
                val response = starWarsApi.getVehicles()
                response.toDomain()?.let {
                    emit(it)
                }
            })
        } catch (e: Exception) {
            Either.Error(Failure.GenericException(error = ErrorModel(e, "000")))
        }
    }
}