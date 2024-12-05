package com.example.starwars.presentation.vehicle.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.core.domain.models.VehicleData
import com.example.starwars.databinding.ItemVehicleBinding

class StarWarsVehicleAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val vehicles = mutableListOf<VehicleData>()
    private lateinit var listener: VehicleListener

    fun updateList(list: List<VehicleData>) {
        vehicles.clear()
        vehicles.addAll(list)
        notifyDataSetChanged()
    }

    fun setListener(listener: VehicleListener) {
        this.listener = listener
    }


    interface VehicleListener {
        fun onVehicleItemClick(vehicleData: VehicleData)
    }


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        return VehicleViewHolder(
            ItemVehicleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class VehicleViewHolder(private val binding: ItemVehicleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(vehicleData: VehicleData) {
            binding.tvName.text = vehicleData.name
            binding.tvModel.text = vehicleData.model
        }
    }

    override fun getItemCount(): Int {
        return vehicles.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as VehicleViewHolder).bind(vehicles[position])
    }
}