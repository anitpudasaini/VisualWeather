package com.weather.weatherapplication

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.weather.weatherapplication.data.Repository
import com.weather.weatherapplication.screens.OneDay
import android.util.Log

class MainActivity : ComponentActivity() {
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var location: android.location.Location
    private lateinit var vWeather: WeatherDayViewModel
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
                    Log.d("debug", "" + (p0.latitude) + "and" + p0.longitude)
                } else {
                    Log.d("debug", "only got null: $p0")
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
        vWeather = ViewModelProvider(this)[WeatherDayViewModel::class.java]
        getWeatherReport(uLocation)
        vWeather.weatherDayViewModel.observe(this) {
            OneDay(this).homeDisplay(vWeather.weatherDayViewModel.value!!)
        }
    }

    fun getWeatherReport(text: String=WeatherConstants.DEFAULT_LOCATION) {
        var qTxt: String = text
        if (text == "") {
            qTxt = uLocation
        }
        vWeather.getWeatherDay(qTxt)
    }
}