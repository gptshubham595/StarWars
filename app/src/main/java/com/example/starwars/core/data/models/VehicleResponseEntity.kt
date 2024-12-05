package com.example.starwars.core.data.models

import com.example.starwars.core.domain.models.VehicleData
import com.google.gson.annotations.SerializedName

data class VehicleResponseEntity(
    val count: Int?,
    val next: String?,
    val previous: String?,
    @SerializedName("results")
    val vehicleEntities: List<VehicleEntity>?
) {
    fun toDomain(): List<VehicleData> {
        vehicleEntities?.let {
            return it.map {
                it.toDomain()
            }
        } ?: run {
            return emptyList()
        }
    }
}