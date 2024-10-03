package com.weather.weatherapplication.api

import com.weather.weatherapplication.WeatherConstants
import com.weather.weatherapplication.models.WeatherDay
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IWeather {
    private fun getKey() = WeatherConstants.visualCrossingApiKey
    private fun getUnit() = WeatherConstants.M_UNIT

    @GET("/VisualCrossingWebServices/rest/services/timeline/{location}?contentType=json")
    fun getWeather(
        @Path("location") location: String,
        @Query("key") key: String = getKey(),
        @Query("unitGroup") unitGroup: String = getUnit()
    ): Call<WeatherDay>

    @GET("/VisualCrossingWebServices/rest/services/timeline/{latitude},{longitude}?contentType=json")
    suspend fun getWeather(
        @Path("latitude") latitude: String,
        @Path("longitude") longitude: String,
        @Query("key") key: String = getKey(),
        @Query("unitGroup") unitGroup: String = getUnit()
    ): Call<WeatherDay>
}