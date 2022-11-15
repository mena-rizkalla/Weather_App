package com.example.weatherapp.network.model


import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("icon")
    val icon: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("main")
    val main: String? = null
)