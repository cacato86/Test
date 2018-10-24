package com.cct.sentiatest.data.net.properties.dto

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class Location(@field:SerializedName("Address") val address: String,
                    @field:SerializedName("Suburb") val suburb: String,
                    @field:SerializedName("State") val state: String,
                    @field:SerializedName("Address2") val address2: String)