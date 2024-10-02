package com.example.example

import com.google.gson.annotations.SerializedName


data class KPAE (

  @SerializedName("distance"     ) var distance     : Int?    = null,
  @SerializedName("latitude"     ) var latitude     : Double? = null,
  @SerializedName("longitude"    ) var longitude    : Double? = null,
  @SerializedName("useCount"     ) var useCount     : Int?    = null,
  @SerializedName("id"           ) var id           : String? = null,
  @SerializedName("name"         ) var name         : String? = null,
  @SerializedName("quality"      ) var quality      : Int?    = null,
  @SerializedName("contribution" ) var contribution : Int?    = null

)