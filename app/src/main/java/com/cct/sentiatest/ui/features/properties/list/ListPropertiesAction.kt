package com.cct.sentiatest.ui.features.properties.list

import com.cct.sentiatest.ui.commons.Action
import com.cct.sentiatest.ui.features.properties.list.item.PropertyVM

sealed class ListPropertiesAction : Action() {
    object LoadProperties : ListPropertiesAction()
    data class OpenDetail(val property: PropertyVM) : ListPropertiesAction()
    object RestoreData : ListPropertiesAction()
}