package com.weather.weatherapplication

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weather.weatherapplication.api.RetrofitInstance
import com.weather.weatherapplication.models.WeatherDay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherDayViewModel : ViewModel() {
    var weatherDayViewModel: MutableLiveData<WeatherDay> = MutableLiveData(WeatherDay())
        get() = field
        set(value){field=value}

    fun getWeatherDay(location:String) {
        viewModelScope.launch {
            Log.d("debug", "calling..")

            RetrofitInstance.visualWeatherService.getWeather(location).enqueue(object :
                Callback<WeatherDay> {
                override fun onResponse(p0: Call<WeatherDay>, p1: Response<WeatherDay>) {
                    Log.d(WeatherConstants.TAG, "value of p0 is $p0")
                    weatherDayViewModel.value = p1.body()
                }

                override fun onFailure(p0: Call<WeatherDay>, p1: Throwable) {
                    Log.e(WeatherConstants.TAG, "got error $p1 and $p0")
                }
            })
        }
    }
}
