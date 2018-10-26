package com.cct.sentiatest.ui.features.properties.list

import com.cct.sentiatest.domain.usecases.ObtainPropertiesUseCase
import com.cct.sentiatest.ui.features.properties.ListPropertiesMapper
import com.cct.sentiatest.ui.features.properties.list.ListPropertiesAction.LoadProperties
import com.cct.sentiatest.ui.features.properties.list.ListPropertiesAction.OpenDetail
import com.cct.sentiatest.ui.features.properties.list.ListPropertiesState.OpenPropertyDetail
import com.cct.sentiatest.ui.features.properties.list.item.PropertyVM
import com.cct.sentiatest.ui.utils.observeOnUI
import com.cct.sentiatest.ui.utils.plusAssign
import com.rise.bgo.ui.features.commons.BasePresenter
import com.rise.bgo.ui.features.commons.BaseView
import javax.inject.Inject


class ListPropertiesPresenter @Inject
constructor(private val obtainProperties: ObtainPropertiesUseCase,
                                                  private val mapper: ListPropertiesMapper)
    : BasePresenter<ListPropertiesState, ListPropertiesAction>() {

    override fun init(view: BaseView<ListPropertiesState>) {
        super.init(view)
        loadProperties()
    }

    override fun reduce(action: ListPropertiesAction) {
        when (action) {
            is LoadProperties -> loadProperties()
            is OpenDetail -> openDetail(action.property)
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
}