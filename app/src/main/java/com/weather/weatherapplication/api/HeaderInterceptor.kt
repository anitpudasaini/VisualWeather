package com.weather.weatherapplication.api

import android.util.Log
import androidx.compose.ui.unit.Constraints
import com.weather.weatherapplication.WeatherConstants
import okhttp3.Interceptor
import okhttp3.MultipartBody
import okhttp3.Response

class HeaderInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("User-Agent","VisualWeather")
            .build()
        return chain.proceed(request)
    }
}