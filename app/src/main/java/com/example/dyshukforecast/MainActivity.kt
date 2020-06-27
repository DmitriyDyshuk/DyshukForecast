package com.example.dyshukforecast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidNetworking.initialize(applicationContext)
        makeRequest()
    }


    private fun makeRequest(){
        AndroidNetworking.get("https://api.openweathermap.org/data/2.5/weather")
            .addQueryParameter("q", "Dnipro")
            .addQueryParameter("appid", "eb7d05cd954e0b91e47b916c41b3cd31")
            .setPriority(Priority.HIGH)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener{
                override fun onResponse(response: JSONObject) {
                    val main = response.getJSONObject("main")
                    val temperature = main.getInt("temp")
                    val name = response.getString("name")

                    val weatherArray = response.getJSONArray("weather")
                    for (i in 0 until weatherArray.length()) {
                        val weatherResult = weatherArray.getJSONObject(i)
                        val description = weatherResult.getString("description")

                        tvDescription.text = description
                    }

                    val const = 273.15F
                    val celsius = temperature - const

                    if(celsius < 0) {
                        ivWeatherIcon.setImageResource(R.drawable.vector_snow_icon)
                    }

                    tvTemperature.text = celsius.toInt().toString()
                    tvCity.text = name
                }

                override fun onError(error: ANError?) {
                    Log.e("Network", "onError:$error")
                }
            })
    }
}