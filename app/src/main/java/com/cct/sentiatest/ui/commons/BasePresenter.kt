package com.rise.bgo.ui.features.commons

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<S : State, in A : Action>() {

    protected val disposables: CompositeDisposable = CompositeDisposable()
    private lateinit var view: BaseView<S>

    open infix fun init(view: BaseView<S>) {
        this.view = view
    }

    abstract infix fun reduce(action: A)

    fun destroy() = disposables.clear()

    protected fun render(state: S) = view.render(state)
}