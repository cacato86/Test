package com.cct.sentiatest.ui.features.properties.list

import com.cct.sentiatest.ui.features.properties.list.item.PropertyVM
import com.cct.sentiatest.ui.commons.State

sealed class ListPropertiesState : State() {
    data class Loading(val loading: Boolean) : ListPropertiesState()
    data class PropertiesLoaded(val properties: List<PropertyVM>) : ListPropertiesState()
    data class OpenPropertyDetail(val id: String) : ListPropertiesState()
    data class GenericError(val error: String) : ListPropertiesState()
}