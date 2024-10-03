package com.weather.weatherapplication.api

import com.google.gson.GsonBuilder
import com.weather.weatherapplication.WeatherConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val client = okhttp3.OkHttpClient.Builder()
        .addInterceptor(HeaderInterceptor())
        .build()

    private val gson = GsonBuilder().setDateFormat("MMM dd,YYYY")
        .create()

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(WeatherConstants.url)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val visualWeatherService: IWeather by lazy {
        retrofit.create(IWeather::class.java)
    }
}