package com.example.starwars.core.data.models

import com.example.starwars.core.domain.models.VehicleData

data class VehicleEntity(
    val cargo_capacity: String?,
    val consumables: String?,
    val cost_in_credits: String?,
    val created: String?,
    val crew: String?,
    val edited: String?,
    val films: List<String>?,
    val length: String?,
    val manufacturer: String?,
    val max_atmosphering_speed: String?,
    val model: String?,
    val name: String?,
    val passengers: String?,
    val pilots: List<String>?,
    val url: String?,
    val vehicle_class: String?
) {
    fun toDomain(): VehicleData {
        return VehicleData(
            model ?: "", name ?: ""
        )
    }
}