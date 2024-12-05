package com.example.starwars.core.data.datasource.network

import com.example.starwars.common.ApiConstants
import com.example.starwars.core.data.models.VehicleResponseEntity
import retrofit2.http.GET

interface StarWarsApiService {

    @GET(ApiConstants.VEHICLES)
    suspend fun getVehicles(): VehicleResponseEntity
}