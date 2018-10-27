package com.cct.sentiatest.domain.usecases

import com.cct.sentiatest.data.bd.SharedPreferencesDataSource
import com.cct.sentiatest.data.net.properties.PropertiesApi
import com.cct.sentiatest.data.net.properties.PropertiesDataSource
import com.cct.sentiatest.data.net.properties.PropertiesMapper
import com.cct.sentiatest.domain.repositories.PropertyRepository
import com.cct.sentiatest.utils.ListPropertiesFactory
import com.cct.sentiatest.utils.ListPropertiesFactory.generateOrderedListParsed
import com.cct.sentiatest.utils.ListPropertiesFactory.generateUnOrderedListParsed
import com.cct.sentiatest.utils.configureRxThreading
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doNothing
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import io.reactivex.Single
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ObtainPropertiesUseCaseTest {

    private lateinit var obtainPropertiesUseCase: ObtainPropertiesUseCase
    private lateinit var propertyRepository: PropertyRepository
    private lateinit var api: PropertiesApi
    private lateinit var sharedPreferencesDS: SharedPreferencesDataSource

    init {
        configureRxThreading()
    }

    @Before
    fun setUp() {
        createMocks()
        propertyRepository = PropertyRepository(PropertiesDataSource(api, PropertiesMapper()), sharedPreferencesDS)
        obtainPropertiesUseCase = ObtainPropertiesUseCase(propertyRepository)
    }

    private fun createMocks() {
        api = mock()
        sharedPreferencesDS = mock()
    }

    @Test
    fun givenUnOrderedList_willReturnOrderedList_withDefaultParameter() {
        given(api.getProperties()).willReturn(Single.just(ListPropertiesFactory.generateUnOrderedList()))
        doNothing().`when`(sharedPreferencesDS).savePropertiesList(any())

        val value = obtainPropertiesUseCase.execute()

        val values = value.test().values()

        assertEquals(values[0], generateOrderedListParsed())
    }

    @Test
    fun givenUnOrderedList_willReturnUnOrderedList_withFalseParameter() {
        given(api.getProperties()).willReturn(Single.just(ListPropertiesFactory.generateUnOrderedList()))
        doNothing().`when`(sharedPreferencesDS).savePropertiesList(any())

        val value = obtainPropertiesUseCase.execute(false)

        val values = value.test().values()

        assertEquals(values[0], generateUnOrderedListParsed())
    }

    @Test
    fun givenUnOrderedList_willReturnOrderedList_withTrueParameter() {
        given(api.getProperties()).willReturn(Single.just(ListPropertiesFactory.generateUnOrderedList()))
        doNothing().`when`(sharedPreferencesDS).savePropertiesList(any())

        val value = obtainPropertiesUseCase.execute(true)

        val values = value.test().values()

        assertEquals(values[0], generateOrderedListParsed())
    }
}