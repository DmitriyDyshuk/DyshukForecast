package com.example.dyshukforecast.presenter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dyshukforecast.R
import com.example.dyshukforecast.model.Weather

class ForecastAdapter(private val values: ArrayList<Weather>): RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {

    override fun getItemCount() =values.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_forecast_wearher, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val weather = values[position]
    }

    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var tvTime = itemView.findViewById(R.id.tvTime) as? TextView
        var ivWeather = itemView.findViewById(R.id.ivWeather) as? ImageView
        var tvTemperature = itemView.findViewById(R.id.tvTemperature) as? TextView
    }
}