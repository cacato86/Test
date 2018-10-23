package com.cct.sentiatest.ui.features.properties.list

import com.rise.bgo.ui.features.commons.Action

sealed class ListPropertiesAction : Action() {
    class LoadProperties : ListPropertiesAction()
}