package com.cct.sentiatest.ui.features.properties.list

import com.cct.sentiatest.domain.usecases.ObtainPropertiesUseCase
import com.cct.sentiatest.domain.usecases.RestorePropertiesUseCase
import com.cct.sentiatest.ui.commons.BasePresenter
import com.cct.sentiatest.ui.features.properties.ListPropertiesMapper
import com.cct.sentiatest.ui.features.properties.list.ListPropertiesAction.*
import com.cct.sentiatest.ui.features.properties.list.ListPropertiesState.OpenPropertyDetail
import com.cct.sentiatest.ui.features.properties.list.item.PropertyVM
import com.cct.sentiatest.ui.utils.observeOnUI
import com.cct.sentiatest.ui.utils.plusAssign
import javax.inject.Inject

class ListPropertiesPresenter @Inject
constructor(private val obtainProperties: ObtainPropertiesUseCase,
            private val restoreProperties: RestorePropertiesUseCase,
            private val mapper: ListPropertiesMapper)
    : BasePresenter<ListPropertiesState, ListPropertiesAction>() {

    override fun reduce(action: ListPropertiesAction) {
        when (action) {
            is LoadProperties -> loadProperties()
            is OpenDetail -> openDetail(action.property)
            is RestoreData -> restoreData()
        }
    }

    private fun loadProperties() {
        disposables += obtainProperties.execute()
                .observeOnUI()
                .doOnSubscribe { render(mapper.mapLoading(true)) }
                .doAfterTerminate { render(mapper.mapLoading(false)) }
                .subscribe({
                    render(mapper.mapListProperties(it))
                }, { render(mapper.mapError(it)) })
    }

    private fun openDetail(property: PropertyVM) {
        render(OpenPropertyDetail(property.id))
    }

    private fun restoreData() {
        disposables += restoreProperties.execute()
                .observeOnUI()
                .subscribe({
                    render(mapper.mapListProperties(it))
                }, { render(mapper.mapError(it)) })
    }
}