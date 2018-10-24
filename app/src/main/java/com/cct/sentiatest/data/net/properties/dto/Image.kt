package com.cct.sentiatest.data.net.properties.dto

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class Image(@field:SerializedName("small") val small: Small,
				 @field:SerializedName("big") val big: Big,
				 @field:SerializedName("medium") val medium: Medium)