package com.rise.bgo.ui.features.commons

interface BaseView<in S : State> {

    infix fun render(state: S)
}