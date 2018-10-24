package com.cct.sentiatest.data.net.properties

import com.cct.sentiatest.data.net.properties.dto.PropertiesResponse
import com.cct.sentiatest.domain.models.Property
import javax.inject.Inject

class PropertiesMapper @Inject constructor() {
    fun mapProperties(properties: PropertiesResponse): List<Property> =
            properties.data.listings.map { it ->
                Property(it.area, it.imageUrls, it.bedrooms, it.bathrooms, it.carspaces, it.displayPrice,
                        it.currency, convertPriority(it.isPremium), it.location.address, it.location.address2,
                        it.location.suburb, it.location.state, it.owner.name, it.owner.lastName, it.owner.image.medium.url)
            }

    private fun convertPriority(priority: Int): Boolean = priority != 0

}