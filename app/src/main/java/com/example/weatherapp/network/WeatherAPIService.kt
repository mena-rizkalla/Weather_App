package com.example.weatherapp.network


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import com.example.weatherapp.network.model.Response
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Query

private const val BASEURL= "https://api.openweathermap.org/data/2.5/"

private val retrofit = Retrofit.Builder().baseUrl(BASEURL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface WeatherAPIService {

    @GET("weather")
    suspend fun getWeatherData(@Query("q") q : String , @Query("appid") appid : String) : Response

}

object WeatherAPI{

    val weatherAPIService : WeatherAPIService by lazy {
        retrofit.create(WeatherAPIService::class.java)
    }

}