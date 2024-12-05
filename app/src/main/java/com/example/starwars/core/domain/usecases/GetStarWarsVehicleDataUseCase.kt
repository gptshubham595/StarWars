package com.example.starwars.core.domain.usecases

import com.example.starwars.common.BaseUseCase
import com.example.starwars.common.Either
import com.example.starwars.common.errorHandling.IFailure
import com.example.starwars.core.domain.models.VehicleData
import com.example.starwars.core.domain.repositories.StartWarsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetStarWarsVehicleDataUseCase @Inject constructor(
    private val starWarsRepo: StartWarsRepository
) : BaseUseCase<Unit, Flow<List<VehicleData>>> {
    override suspend fun run(params: Unit): Either<IFailure, Flow<List<VehicleData>>> {
        return when (val result = starWarsRepo.getStarWarsVehicleList()) {
            is Either.Error -> Either.Error(result.exception)
            is Either.Success -> Either.Success(result.data)
        }
    }
}