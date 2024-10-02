package com.example.example

import com.google.gson.annotations.SerializedName


data class Days (

  @SerializedName("datetime"       ) var datetime       : String?           = null,
  @SerializedName("datetimeEpoch"  ) var datetimeEpoch  : Int?              = null,
  @SerializedName("tempmax"        ) var tempmax        : Double?           = null,
  @SerializedName("tempmin"        ) var tempmin        : Double?           = null,
//  @SerializedName("temp"           ) var temp           : Int?              = null,
//  @SerializedName("feelslikemax"   ) var feelslikemax   : Double?           = null,
//  @SerializedName("feelslikemin"   ) var feelslikemin   : Double?           = null,
//  @SerializedName("feelslike"      ) var feelslike      : Int?              = null,
//  @SerializedName("dew"            ) var dew            : Double?           = null,
//  @SerializedName("humidity"       ) var humidity       : Double?           = null,
  @SerializedName("precip"         ) var precip         : Double?           = null,
//  @SerializedName("precipprob"     ) var precipprob     : Int?              = null,
//  @SerializedName("precipcover"    ) var precipcover    : Double?           = null,
  @SerializedName("preciptype"     ) var preciptype     : ArrayList<String> = arrayListOf(),
//  @SerializedName("snow"           ) var snow           : Int?              = null,
//  @SerializedName("snowdepth"      ) var snowdepth      : Int?              = null,
//  @SerializedName("windgust"       ) var windgust       : Double?           = null,
//  @SerializedName("windspeed"      ) var windspeed      : Int?              = null,
//  @SerializedName("winddir"        ) var winddir        : Double?           = null,
////  @SerializedName("pressure"       ) var pressure       : Double?           = null,
//  @SerializedName("cloudcover"     ) var cloudcover     : Double?           = null,
//  @SerializedName("visibility"     ) var visibility     : Double?           = null,
//  @SerializedName("solarradiation" ) var solarradiation : Double?           = null,
//  @SerializedName("solarenergy"    ) var solarenergy    : Double?           = null,
//  @SerializedName("uvindex"        ) var uvindex        : Int?              = null,
//  @SerializedName("severerisk"     ) var severerisk     : Int?              = null,
  @SerializedName("sunrise"        ) var sunrise        : String?           = null,
//  @SerializedName("sunriseEpoch"   ) var sunriseEpoch   : Int?              = null,
  @SerializedName("sunset"         ) var sunset         : String?           = null,
//  @SerializedName("sunsetEpoch"    ) var sunsetEpoch    : Int?              = null,
//  @SerializedName("moonphase"      ) var moonphase      : Double?           = null,
//  @SerializedName("conditions"     ) var conditions     : String?           = null,
//  @SerializedName("description"    ) var description    : String?           = null,
//  @SerializedName("icon"           ) var icon           : String?           = null,
//  @SerializedName("stations"       ) var stations       : ArrayList<String> = arrayListOf(),
//  @SerializedName("source"         ) var source         : String?           = null,
//  @SerializedName("hours"          ) var hours          : ArrayList<Hours>  = arrayListOf()

)