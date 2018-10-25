package com.cct.sentiatest.ui.features.properties.list

import com.cct.sentiatest.data.net.properties.PropertiesApi
import com.cct.sentiatest.data.net.properties.PropertiesDataSource
import com.cct.sentiatest.data.net.properties.PropertiesMapper
import com.cct.sentiatest.domain.repositories.PropertyRepository
import com.cct.sentiatest.domain.usecases.ObtainPropertiesUseCase
import com.cct.sentiatest.ui.features.properties.ListPropertiesMapper
import com.cct.sentiatest.ui.features.properties.list.ListPropertiesState.*
import com.cct.sentiatest.utils.ListPropertiesFactory.generateEmptyPropertiesResponse
import com.cct.sentiatest.utils.configureRxThreading
import com.nhaarman.mockito_kotlin.*
import com.rise.bgo.ui.features.commons.BaseView
import io.reactivex.Single
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.MockitoAnnotations

class ListPropertiesPresenterTest {

    private lateinit var obtainPropertiesUseCase: ObtainPropertiesUseCase
    private lateinit var presenter: ListPropertiesPresenter
    private lateinit var view: BaseView<ListPropertiesState>
    private lateinit var propertyRepository: PropertyRepository

    @Captor
    private lateinit var captor: ArgumentCaptor<ListPropertiesState>

    init {
        configureRxThreading()
    }

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        createMocks()
        propertyRepository = PropertyRepository(PropertiesDataSource(api, PropertiesMapper()))
        obtainPropertiesUseCase = ObtainPropertiesUseCase(propertyRepository)
        presenter = ListPropertiesPresenter(obtainPropertiesUseCase, ListPropertiesMapper())
    }

    private lateinit var api: PropertiesApi

    private fun createMocks() {
        view = mock()
        api = mock()
    }

    @Test
    fun onInit_renderLoadingState() {
        given(api.getProperties()).willReturn(Single.just(generateEmptyPropertiesResponse()))

        presenter init view

        verify(view, times(3)).render(capture(captor))
        with(captor.allValues) {
            assertLoadingState(get(0), true)
            assertLoadingState(get(2), false)
        }
    }

    @Test
    fun onInit_renderPropertiesSuccessful() {
        given(api.getProperties()).willReturn(Single.just(generateEmptyPropertiesResponse()))

        presenter init view

        verify(view, times(3)).render(capture(captor))
        with(captor.allValues) {
            assertPropertiesLoadedState(get(1))
        }
    }

    @Test
    fun onInit_renderRenderGeneralErrorWhenRequestFail() {
        given(api.getProperties()).willReturn(Single.error(Throwable("Error")))

        presenter init view

        verify(view, times(3)).render(capture(captor))
        with(captor.allValues) {
            assertGeneralErrorState(get(1))
        }
    }

    private fun assertLoadingState(state: ListPropertiesState, visible: Boolean) {
        assertTrue(state is Loading)
        assertTrue((state as Loading).loading == visible)
    }

    private fun assertPropertiesLoadedState(state: ListPropertiesState) {
        assertTrue(state is PropertiesLoaded)
        assertTrue((state as PropertiesLoaded).properties.isEmpty())
    }

    private fun assertGeneralErrorState(state: ListPropertiesState) {
        assertTrue(state is GenericError)
        assertTrue((state as GenericError).error == "Error")
    }
}