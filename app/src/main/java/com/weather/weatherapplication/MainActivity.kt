package com.weather.weatherapplication

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.weather.weatherapplication.data.Repository
import com.weather.weatherapplication.screens.OneDay
import android.util.Log
import androidx.activity.viewModels
import com.weather.weatherapplication.models.WeatherViewModel

class MainActivity : ComponentActivity() {
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var location: android.location.Location
    private val vWeather by viewModels<WeatherViewModel>()
    private var uLocation: String = ""

    @SuppressLint("ServiceCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
            fusedLocationProviderClient.lastLocation.addOnSuccessListener(
                this
            ) { p0 ->

                if (p0 != null) {
                    uLocation = "${p0.latitude},${p0.longitude}"
                    Log.d(WeatherConstants.TAG, "Location obtained: " + (p0.latitude) + "and" + p0.longitude)
                } else {
                    Log.d(WeatherConstants.TAG, "only got null: $p0")
                }
            }

            if (ActivityCompat.checkSelfPermission(
                    this,
                    ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {

                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(ACCESS_COARSE_LOCATION, ACCESS_FINE_LOCATION),
                    PackageManager.PERMISSION_GRANTED
                )
            }
        } catch (e: Exception) {
            Log.e(WeatherConstants.TAG, "can't get user Location, setting to default location $e")
        }

        enableEdgeToEdge()
        if(uLocation=="") uLocation= WeatherConstants.DEFAULT_LOCATION
        val repo = Repository(this)
//        vWeather = ViewModelProvider(this)[WeatherViewModel::class.java]
        getWeatherReport(uLocation)
        vWeather.weatherDayViewModel.observe(this) {
            OneDay(this).homeDisplay(vWeather.weatherDayViewModel.value, vWeather.isBusy.value)
        }
//        OneDay(this).homeDisplay(vWeather)
    }

    fun getWeatherReport(text: String=WeatherConstants.DEFAULT_LOCATION) {
        var qTxt: String = text
        if (text == "") {
            qTxt = uLocation
        }
        vWeather.getWeatherDay(qTxt)
    }
}