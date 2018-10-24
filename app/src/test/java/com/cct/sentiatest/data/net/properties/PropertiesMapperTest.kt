package com.cct.sentiatest.data.net.properties

import com.cct.sentiatest.data.net.properties.dto.*
import com.cct.sentiatest.domain.models.Property
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class PropertiesMapperTest {
    private lateinit var mapper: PropertiesMapper

    @Before
    fun setUp() {
        mapper = PropertiesMapper()
    }

    @Test
    fun givenCorrectPropertiesResponse_willReturnListPropertiesWithSameLength() {
        val correctPropertiesResponse: PropertiesResponse = generatePropertiesResponse()
        val mappedResponse = mapper.mapProperties(correctPropertiesResponse)
        val correctListProperty: List<Property> = generateCorrectPropertyMapped()
        assertTrue(mappedResponse.size == correctListProperty.size)
    }

    @Test
    fun givenCorrectPropertiesResponse_willReturnListPropertiesCorrect() {
        val correctPropertiesResponse: PropertiesResponse = generatePropertiesResponse()
        val mappedResponse = mapper.mapProperties(correctPropertiesResponse)
        val correctListProperty: List<Property> = generateCorrectPropertyMapped()
        assertEquals(mappedResponse, correctListProperty)
    }

    private fun generatePropertiesResponse(): PropertiesResponse =
            PropertiesResponse(0, Data(listOf(dtoListItem(0), dtoListItem(1))), "")

    private fun dtoListItem(premium: Int): ListingsItem =
            ListingsItem(Owner("Red", Image(Small(""), Big(""), Medium("medium")), "", "James"),
                    "", "description", listOf("url", "url2"), "", 0.0, 0.0, "", "", "",
                    "", "area", premium, 1, 1, 1, "AUD", "", 1, "20000", "1",
                    Location("address", "suburb", "state", "address2"), 0, "")

    private fun generateCorrectPropertyMapped(): List<Property> = listOf(modelListItem(false), modelListItem(true))

    private fun modelListItem(premium: Boolean): Property =
            Property("area", listOf("url", "url2"), 1, 1, 1, "20000", "AUD", premium, "address", "address2",
                    "suburb", "state", "James", "Red", "medium")
}