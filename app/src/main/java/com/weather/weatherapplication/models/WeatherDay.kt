package com.weather.weatherapplication.models

import com.example.example.CurrentConditions
import com.example.example.Days
import com.google.gson.annotations.SerializedName

data class WeatherDay (

  @SerializedName("queryCost"         ) var queryCost         : Int?               = null,
  @SerializedName("latitude"          ) var latitude          : Double?            = null,
  @SerializedName("longitude"         ) var longitude         : Double?            = null,
  @SerializedName("resolvedAddress"   ) var resolvedAddress   : String?            = null,
  @SerializedName("address"           ) var address           : String?            = null,
  @SerializedName("timezone"          ) var timezone          : String?            = null,
  @SerializedName("tzoffset"          ) var tzoffset          : Double?               = null,
  @SerializedName("description"       ) var description       : String?            = null,
  @SerializedName("days"              ) var days              : ArrayList<Days>    = arrayListOf(),
//  @SerializedName("alerts"            ) var alerts            : ArrayList<String>  = arrayListOf(),
//  @SerializedName("stations"          ) var stations          : Stations?          = Stations(),
  @SerializedName("currentConditions" ) var currentConditions : CurrentConditions? = CurrentConditions()

)