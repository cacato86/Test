package com.cct.sentiatest.ui.features.properties.list

import com.cct.sentiatest.domain.usecases.ObtainProperties
import com.cct.sentiatest.ui.features.properties.ListPropertiesMapper
import com.cct.sentiatest.ui.features.properties.list.ListPropertiesAction.LoadProperties
import com.cct.sentiatest.ui.utils.observeOnUI
import com.cct.sentiatest.ui.utils.plusAssign
import com.rise.bgo.ui.features.commons.BasePresenter
import com.rise.bgo.ui.features.commons.BaseView
import javax.inject.Inject

class ListPropertiesPresenter @Inject constructor(private val obtainProperties: ObtainProperties,
                                                  private val mapper: ListPropertiesMapper)
    : BasePresenter<ListPropertiesState, ListPropertiesAction>() {

    override fun init(view: BaseView<ListPropertiesState>) {
        super.init(view)
        loadProperties()
    }

    override fun reduce(action: ListPropertiesAction) {
        when (action) {
            is LoadProperties -> loadProperties()
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
}