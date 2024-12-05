package com.example.starwars.presentation.vehicle.views

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.starwars.core.domain.models.VehicleData
import com.example.starwars.databinding.ActivityMainBinding
import com.example.starwars.presentation.vehicle.adapters.StarWarsVehicleAdapter
import com.example.starwars.presentation.vehicle.viewModels.StarWarsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class StarWarsActivity : AppCompatActivity(), StarWarsVehicleAdapter.VehicleListener {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: StarWarsViewModel by viewModels()

    private val adapter: StarWarsVehicleAdapter by lazy { StarWarsVehicleAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getStarWarsVehicleData()

        initView()
        initAdapter()
        initObserver()
    }

    private fun initAdapter() {
        adapter.setListener(this)
        binding.rvVehicles.adapter = adapter
    }

    private fun initObserver() {
        lifecycleScope.launch {
            viewModel.vehicleDataFlow.collect { it ->
                // handle vehicle data
                it?.let {
                    adapter.updateList(it)
                }
            }
        }
    }

    private fun initView() {

    }

    override fun onVehicleItemClick(vehicleData: VehicleData) {
        Toast.makeText(this, "Vehicle Clicked", Toast.LENGTH_SHORT).show()
    }


}