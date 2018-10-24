package com.rise.bgo.ui.util.ext

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

const val TIMEOUT: Long = 30L

fun OkHttpClient.Builder.addTimeout(): OkHttpClient.Builder {
    return this.connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
}