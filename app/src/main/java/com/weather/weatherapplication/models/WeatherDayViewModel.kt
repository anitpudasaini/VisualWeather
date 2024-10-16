package com.weather.weatherapplication.models

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weather.weatherapplication.WeatherConstants
import com.weather.weatherapplication.api.RetrofitInstance
import com.weather.weatherapplication.data.WeatherDay
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherViewModel : ViewModel() {
    var weatherDayViewModel: MutableLiveData<WeatherDay> = MutableLiveData(WeatherDay())
        get() = field
        set(value){field=value}

    var isBusy = mutableStateOf(false)
    fun getWeatherDay(location:String) {
        isBusy.value = true
        viewModelScope.launch {
            Log.d(WeatherConstants.TAG, "calling..")
            delay(2000)
            RetrofitInstance.visualWeatherService.getWeather(location).enqueue(object :
                Callback<WeatherDay> {
                override fun onResponse(p0: Call<WeatherDay>, p1: Response<WeatherDay>) {
                    Log.d(WeatherConstants.TAG, "value of p0 is $p0 and p1 is $p1")

                    isBusy.value = false
                    weatherDayViewModel.value = p1.body()

                    Log.d(WeatherConstants.TAG, "Weather set to false1: $isBusy and ${isBusy.value}")
                }

                override fun onFailure(p0: Call<WeatherDay>, p1: Throwable) {
                    isBusy.value = false
                    Log.e(WeatherConstants.TAG, "got error $p1 and $p0")
                    Log.d(WeatherConstants.TAG, "Weather set to false: $isBusy and ${isBusy.value}")
                }
            })
        }
    }
}
