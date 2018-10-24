package com.cct.sentiatest.ui.features.properties

import com.cct.sentiatest.domain.models.Property
import com.cct.sentiatest.ui.features.properties.list.ListPropertiesState
import com.cct.sentiatest.ui.features.properties.list.ListPropertiesState.*
import com.cct.sentiatest.ui.features.properties.list.item.PropertyVM
import javax.inject.Inject

class ListPropertiesMapper @Inject constructor() {

    fun mapListProperties(properties: List<Property>): PropertiesLoaded =
            PropertiesLoaded(properties.map { it ->
                PropertyVM(it.area, "${it.bedrooms}", "${it.bathrooms}", "${it.carSpaces}",
                        it.description, it.imageUrls[3], formatPrice(it.price, it.currency),
                        formatOwnerName(it.ownerName, it.ownerLastName), it.ownerImage,
                        formatAddress(it.address, it.state), it.isPremium)
            })

    fun mapLoading(visible: Boolean): ListPropertiesState = Loading(visible)

    fun mapError(it: Throwable): ListPropertiesState = GenericError(it.localizedMessage)

    private fun formatPrice(price: String, currency: String): String = "$price $currency"

    private fun formatOwnerName(ownerName: String, ownerLastName: String) = "$ownerName $ownerLastName"

    private fun formatAddress(address: String, state: String): String = "$address , $state"

}