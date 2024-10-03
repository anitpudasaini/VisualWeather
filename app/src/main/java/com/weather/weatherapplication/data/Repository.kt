package com.weather.weatherapplication.data

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.weather.weatherapplication.WeatherConstants
import com.weather.weatherapplication.MainActivity
import com.weather.weatherapplication.WeatherDayViewModel
import com.weather.weatherapplication.models.WeatherDay
import java.io.IOException
import java.io.InputStream
import java.text.DateFormat

class Repository(val weatherContext: Context) {
    private val srcFile:String = WeatherConstants.srcSample
    private val online:Boolean = false
    private lateinit var vWeather: WeatherDay

    fun weatherReport():WeatherDay{
        if(online){
//            vWeather = ViewModelProvider(weatherContext as MainActivity)[WeatherDayViewModel::class.java]
//                vWeather.weatherDayViewModel
//            RetrofitInstance.visualWeatherService
//                .getWeather("Bothell WA")
//                .also { val temp = it.execute().body()
//                    if(temp==null){
//                        Log.d("debug","service call gives null")
//                    }else{
//                        vWeather.weatherDayViewModel.value = temp
//                    }
//                }
        }else {
            val jsonString: String = readFile("alpha.json")
            val gson: Gson = GsonBuilder()
                .setDateFormat(DateFormat.FULL, DateFormat.FULL)
                .create()
            vWeather = gson.fromJson(jsonString, WeatherDay::class.java)
        }
        return vWeather
    }

    @Throws(IOException::class)
    fun readFile(path: String?): String {
        val stream: InputStream = weatherContext.assets.open(srcFile)
        val size = stream.available()
        val buffer = ByteArray(size)
        stream.read(buffer)
        stream.close()

        val json = String(buffer, charset("UTF-8"))
        return json
    }

}