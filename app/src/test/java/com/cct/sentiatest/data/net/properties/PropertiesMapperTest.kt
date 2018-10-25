package com.cct.sentiatest.data.net.properties

import com.cct.sentiatest.data.net.properties.dto.PropertiesResponse
import com.cct.sentiatest.domain.models.Property
import com.cct.sentiatest.utils.ListPropertiesFactory.generateCorrectPropertyMapped
import com.cct.sentiatest.utils.ListPropertiesFactory.generatePropertiesResponse
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
}