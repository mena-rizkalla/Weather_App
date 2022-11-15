package com.example.weatherapp.network.model


import com.google.gson.annotations.SerializedName

data class Sys(
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("sunrise")
    val sunrise: Int? = null,
    @SerializedName("sunset")
    val sunset: Int? = null,
    @SerializedName("type")
    val type: Int? = null
)