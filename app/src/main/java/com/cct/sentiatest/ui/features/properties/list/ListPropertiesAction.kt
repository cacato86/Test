package com.cct.sentiatest.ui.features.properties.list

import com.cct.sentiatest.ui.features.properties.list.item.PropertyVM
import com.rise.bgo.ui.features.commons.Action

sealed class ListPropertiesAction : Action() {
    class LoadProperties : ListPropertiesAction()
    data class OpenDetail(val property: PropertyVM) : ListPropertiesAction()
}