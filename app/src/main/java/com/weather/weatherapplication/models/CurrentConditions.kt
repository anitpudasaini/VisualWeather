package com.example.example

import com.google.gson.annotations.SerializedName


data class CurrentConditions (

  @SerializedName("datetime"       ) var datetime       : String?           = null,
  @SerializedName("datetimeEpoch"  ) var datetimeEpoch  : Int?              = null,
  @SerializedName("temp"           ) var temp           : Double?           = null,
  @SerializedName("feelslike"      ) var feelslike      : Double?           = null,
  @SerializedName("humidity"       ) var humidity       : Double?           = null,
  @SerializedName("dew"            ) var dew            : Double?              = null,
  @SerializedName("precip"         ) var precip         : Double?           = null,
  @SerializedName("precipprob"     ) var precipprob     : Int?              = null,
  @SerializedName("snow"           ) var snow           : Int?              = null,
  @SerializedName("snowdepth"      ) var snowdepth      : Int?              = null,
  @SerializedName("preciptype"     ) var preciptype     : ArrayList<String> = arrayListOf(),
  @SerializedName("windgust"       ) var windgust       : Double?           = null,
  @SerializedName("windspeed"      ) var windspeed      : Double?           = null,
  @SerializedName("winddir"        ) var winddir        : Int?              = null,
  @SerializedName("pressure"       ) var pressure       : Int?              = null,
  @SerializedName("visibility"     ) var visibility     : Int?              = null,
  @SerializedName("cloudcover"     ) var cloudcover     : Int?              = null,
  @SerializedName("solarradiation" ) var solarradiation : Int?              = null,
  @SerializedName("solarenergy"    ) var solarenergy    : Double?           = null,
  @SerializedName("uvindex"        ) var uvindex        : Int?              = null,
  @SerializedName("conditions"     ) var conditions     : String?           = null,
  @SerializedName("icon"           ) var icon           : String?           = null,
  @SerializedName("stations"       ) var stations       : ArrayList<String> = arrayListOf(),
  @SerializedName("source"         ) var source         : String?           = null,
  @SerializedName("sunrise"        ) var sunrise        : String?           = null,
  @SerializedName("sunriseEpoch"   ) var sunriseEpoch   : Int?              = null,
  @SerializedName("sunset"         ) var sunset         : String?           = null,
  @SerializedName("sunsetEpoch"    ) var sunsetEpoch    : Int?              = null,
  @SerializedName("moonphase"      ) var moonphase      : Double?           = null

)