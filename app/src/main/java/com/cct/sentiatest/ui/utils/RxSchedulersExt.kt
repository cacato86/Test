package com.cct.sentiatest.ui.utils

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun Completable.observeOnUI() = with(this) {
    observeOn(AndroidSchedulers.mainThread())
}

fun <T> Flowable<T>.observeOnUI() = with(this) {
    observeOn(AndroidSchedulers.mainThread())
}

fun <T> Observable<T>.observeOnUI() = with(this) {
    observeOn(AndroidSchedulers.mainThread())
}

fun <T> Single<T>.observeOnUI() = with(this) {
    observeOn(AndroidSchedulers.mainThread())
}

fun <T> Maybe<T>.observeOnUI() = with(this) {
    observeOn(AndroidSchedulers.mainThread())
}

fun Completable.subscribeOnIO() = with(this) {
    subscribeOn(Schedulers.io())
}

fun <T> Flowable<T>.subscribeOnIO() = with(this) {
    subscribeOn(Schedulers.io())
}

fun <T> Observable<T>.subscribeOnIO() = with(this) {
    subscribeOn(Schedulers.io())
}

fun <T> Single<T>.subscribeOnIO() = with(this) {
    subscribeOn(Schedulers.io())
}

fun <T> Maybe<T>.subscribeOnIO() = with(this) {
    subscribeOn(Schedulers.io())
}
