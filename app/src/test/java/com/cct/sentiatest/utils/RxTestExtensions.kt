package com.cct.sentiatest.utils

import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.disposables.Disposable
import io.reactivex.internal.schedulers.ExecutorScheduler
import io.reactivex.plugins.RxJavaPlugins
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit


fun configureRxThreading() {
    RxJavaPlugins.reset()
    val immediate = object : Scheduler() {

        override fun scheduleDirect(run: Runnable, delay: Long, unit: TimeUnit): Disposable {
            return super.scheduleDirect(run, 0, unit)
        }

        override fun createWorker(): Worker {
            return ExecutorScheduler.ExecutorWorker(Executor { it.run() })
        }
    }

    RxJavaPlugins.setInitIoSchedulerHandler { immediate }
    RxJavaPlugins.setInitComputationSchedulerHandler { immediate }
    RxJavaPlugins.setInitNewThreadSchedulerHandler { immediate }
    RxJavaPlugins.setInitSingleSchedulerHandler { immediate }
    RxAndroidPlugins.setInitMainThreadSchedulerHandler { immediate }
}
