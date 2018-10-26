package com.cct.sentiatest.ui.commons

interface BaseView<in S : State> {
    infix fun render(state: S)
}