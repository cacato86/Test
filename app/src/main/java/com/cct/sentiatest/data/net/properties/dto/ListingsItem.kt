package com.cct.sentiatest.data.net.properties.dto

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class ListingsItem(@field:SerializedName("owner") val owner: Owner,
                        @field:SerializedName("ListingTypeString") val listingTypeString: String,
                        @field:SerializedName("Description") val description: String,
                        @field:SerializedName("ImageUrls") val imageUrls: List<String>,
                        @field:SerializedName("DateUpdated") val dateUpdated: String,
                        @field:SerializedName("Latitude") val latitude: Double,
                        @field:SerializedName("Longitude") val longitude: Double,
                        @field:SerializedName("AvailableFrom") val availableFrom: Any,
                        @field:SerializedName("DateFirstListed") val dateFirstListed: String,
                        @field:SerializedName("AgencyLogoUrl") val agencyLogoUrl: String,
                        @field:SerializedName("ListingStatistics") val listingStatistics: Any,
                        @field:SerializedName("Area") val area: String,
                        @field:SerializedName("is_premium") val isPremium: Int,
                        @field:SerializedName("Bedrooms") val bedrooms: Int,
                        @field:SerializedName("ListingPrice") val listingPrice: Any,
                        @field:SerializedName("Carspaces") val carspaces: Int,
                        @field:SerializedName("Currency") val currency: String,
                        @field:SerializedName("AuctionDate") val auctionDate: String,
                        @field:SerializedName("Bathrooms") val bathrooms: Int,
                        @field:SerializedName("DisplayPrice") val displayPrice: String,
                        @field:SerializedName("Id") val id: String,
                        @field:SerializedName("Location") val location: Location,
                        @field:SerializedName("IsPriority") val isPriority: Int,
                        @field:SerializedName("ListingType") val listingType: String)