package com.example.starwars.presentation.vehicle.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwars.core.domain.models.VehicleData
import com.example.starwars.core.domain.usecases.GetStarWarsVehicleDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StarWarsViewModel @Inject constructor(
    private val getStarWarsVehicleDataUseCase: GetStarWarsVehicleDataUseCase
) : ViewModel() {

    private val _vehicleDataFlow = MutableStateFlow<List<VehicleData>>(emptyList())
    val vehicleDataFlow = _vehicleDataFlow.asStateFlow()

    fun getStarWarsVehicleData() {
        getStarWarsVehicleDataUseCase.invoke(viewModelScope, Unit, { it: Flow<List<VehicleData>> ->
            // onSuccess
            viewModelScope.launch {
                _vehicleDataFlow.emitAll(it)
            }
        }, {
            // onFailure

        })
    }
}