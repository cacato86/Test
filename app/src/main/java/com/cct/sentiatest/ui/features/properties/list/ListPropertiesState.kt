package com.cct.sentiatest.ui.features.properties.list

import com.cct.sentiatest.ui.features.properties.list.item.PropertyVM
import com.rise.bgo.ui.features.commons.State

sealed class ListPropertiesState : State() {
    data class Loading(val loading: Boolean) : ListPropertiesState()
    data class PropertiesLoaded(val properties: List<PropertyVM>) : ListPropertiesState()
    data class GenericError(val error: String): ListPropertiesState()
}