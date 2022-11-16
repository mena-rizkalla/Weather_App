package com.example.weatherapp

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.network.WeatherAPI
import com.example.weatherapp.network.model.Response
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    val key = "49f5beb41509baa76ede3355ad566b21"

    val reponseStateFlow : MutableStateFlow<Response> = MutableStateFlow<Response>(Response())

     fun weather(){
        viewModelScope.launch {
            reponseStateFlow.emit(WeatherAPI.weatherAPIService.getWeatherData("Cairo",key))
        }
    }
}

/**suspend fun getData(key : String , city : String){
    val result =  WeatherAPI.weatherAPIService.getWeatherData(city,key)
    binding.cityName.text = result.name.toString()
    binding.currentTemp.text = result.main?.temp.toString()
    binding.humidity.text = result.main?.humidity.toString()
    binding.maxTem.text = result.main?.tempMax.toString()
    binding.minTemp.text = result.main?.tempMin.toString()
}**/