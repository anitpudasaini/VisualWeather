package com.example.example

import com.google.gson.annotations.SerializedName


data class Stations (

  @SerializedName("KPWT"  ) var KPWT  : KPWT?  = KPWT(),
  @SerializedName("KSEA"  ) var KSEA  : KSEA?  = KSEA(),
  @SerializedName("D7465" ) var D7465 : D7465? = D7465(),
  @SerializedName("KBFI"  ) var KBFI  : KBFI?  = KBFI(),
  @SerializedName("KPAE"  ) var KPAE  : KPAE?  = KPAE(),
  @SerializedName("D2690" ) var D2690 : D2690? = D2690(),
  @SerializedName("F8270" ) var F8270 : F8270? = F8270(),
  @SerializedName("KAWO"  ) var KAWO  : KAWO?  = KAWO(),
  @SerializedName("KRNT"  ) var KRNT  : KRNT?  = KRNT()

)