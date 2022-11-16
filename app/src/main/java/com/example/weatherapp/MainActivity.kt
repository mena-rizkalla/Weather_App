package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.weatherapp.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding;
    private lateinit var weatherViewModel : WeatherViewModel ;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        weatherViewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)

        weatherViewModel.weather();
        lifecycleScope.launch {
            weatherViewModel.reponseStateFlow.collect{
                withContext(Dispatchers.Main){
                binding.cityName.text = it.name.toString()
                binding.currentTemp.text = it.main?.temp.toString()
                binding.humidity.text = it.main?.humidity.toString()
                binding.maxTem.text = it.main?.tempMax.toString()
                binding.minTemp.text = it.main?.tempMin.toString()}
            }
        }

    }


}