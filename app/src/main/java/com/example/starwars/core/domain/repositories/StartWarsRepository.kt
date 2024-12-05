package com.example.starwars.core.domain.repositories

import com.example.starwars.common.Either
import com.example.starwars.common.errorHandling.IFailure
import com.example.starwars.core.domain.models.VehicleData
import kotlinx.coroutines.flow.Flow

interface StartWarsRepository {
    suspend fun getStarWarsVehicleList(): Either<IFailure, Flow<List<VehicleData>>>
}