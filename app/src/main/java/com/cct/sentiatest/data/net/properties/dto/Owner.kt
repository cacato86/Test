package com.cct.sentiatest.data.net.properties.dto

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class Owner(@field:SerializedName("lastName") val lastName: String,
                 @field:SerializedName("image") val image: Image,
                 @field:SerializedName("dob") val dob: String,
                 @field:SerializedName("name") val name: String)