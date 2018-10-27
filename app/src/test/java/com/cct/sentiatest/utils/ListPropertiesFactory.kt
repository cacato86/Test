package com.cct.sentiatest.utils

import com.cct.sentiatest.data.net.properties.dto.*
import com.cct.sentiatest.domain.models.Property

object ListPropertiesFactory {
    fun generateEmptyPropertiesResponse() = PropertiesResponse(0, Data(listOf()), "")

    fun generatePropertiesResponse(): PropertiesResponse =
            PropertiesResponse(0, Data(listOf(dtoListItem(0), dtoListItem(1))), "")

    private fun dtoListItem(premium: Int): ListingsItem =
            ListingsItem(Owner("Red", Image(Small(""), Big(""), Medium("medium")), "", "James"),
                    "", "description", listOf("url", "url2"), "", 0.0, 0.0, "", "", "",
                    "", "area", premium, 1, 1, 1, "AUD", "", 1, "20000", "1",
                    Location("address", "suburb", "state", "address2"), 0, "")

    fun generateCorrectPropertyMapped(): List<Property> = listOf(modelListItem(false), modelListItem(true))

    private fun modelListItem(premium: Boolean): Property =
            Property("1", "area", listOf("url", "url2"), 1, 1, 1, "20000", "AUD", premium, "address",
                    "address2", "suburb", "state", "James", "Red", "medium", "description")

    fun generateUnOrderedList(): PropertiesResponse =
            PropertiesResponse(0, Data(listOf(dtoListItem(0), dtoListItem(1), dtoListItem(1), dtoListItem(0))), "")

    fun generateOrderedListParsed(): List<Property> =
            listOf(modelListItem(true), modelListItem(true), modelListItem(false), modelListItem(false))

    fun generateUnOrderedListParsed(): List<Property> =
            listOf(modelListItem(false), modelListItem(true), modelListItem(true), modelListItem(false))
}