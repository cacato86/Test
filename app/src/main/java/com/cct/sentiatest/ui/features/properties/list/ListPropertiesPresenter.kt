package com.cct.sentiatest.ui.features.properties.list

import com.cct.sentiatest.ui.features.properties.list.ListPropertiesAction.LoadProperties
import com.rise.bgo.ui.features.commons.BasePresenter
import javax.inject.Inject

class ListPropertiesPresenter @Inject constructor()
    : BasePresenter<ListPropertiesState, ListPropertiesAction>() {

    override fun reduce(action: ListPropertiesAction) {
        when (action) {
            is LoadProperties -> loadProperties()
        }
    }

    private fun loadProperties() {

    }
}