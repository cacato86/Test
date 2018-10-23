package com.cct.sentiatest.ui.features.properties.list

import com.cct.sentiatest.ui.features.properties.list.ListPropertiesAction.LoadProperties
import com.cct.sentiatest.ui.features.properties.list.ListPropertiesState.RenderProperties
import com.cct.sentiatest.ui.features.properties.list.item.PropertyVM
import com.rise.bgo.ui.features.commons.BasePresenter
import com.rise.bgo.ui.features.commons.BaseView
import javax.inject.Inject

class ListPropertiesPresenter @Inject constructor()
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

        //FAKE DATA
        val list = listOf(
                PropertyVM("Area 1", "1", "1", true),
                PropertyVM("Area 2", "1", "1", true),
                PropertyVM("Area 3", "1", "1", false),
                PropertyVM("Area 4", "1", "1", false))
        render(RenderProperties(list))
    }
}