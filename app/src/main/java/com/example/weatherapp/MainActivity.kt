package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.network.WeatherAPI
import com.example.weatherapp.network.WeatherAPIService
import com.example.weatherapp.network.model.Response
import com.example.weatherapp.network.model.Weather
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding;
    val key = "49f5beb41509baa76ede3355ad566b21"
    lateinit var city:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        GlobalScope.launch{

            withContext(Dispatchers.Main){
                getData(key,"Cairo")

            }
        }
    }

    suspend fun getData(key : String , city : String){
        val result =  WeatherAPI.weatherAPIService.getWeatherData(city,key)
        binding.cityName.text = result.name.toString()
        binding.currentTemp.text = result.main?.temp.toString()
        binding.humidity.text = result.main?.humidity.toString()
        binding.maxTem.text = result.main?.tempMax.toString()
        binding.minTemp.text = result.main?.tempMin.toString()
    }
}