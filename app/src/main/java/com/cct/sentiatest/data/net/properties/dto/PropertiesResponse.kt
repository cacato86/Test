package com.cct.sentiatest.data.net.properties.dto

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class PropertiesResponse(@field:SerializedName("ad_id") val adId: Int,
                              @field:SerializedName("data") val data: Data,
                              @field:SerializedName("title") val title: String)