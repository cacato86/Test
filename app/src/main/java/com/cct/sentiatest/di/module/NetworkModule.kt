package com.cct.sentiatest.di.module

import android.content.Context
import com.cct.sentiatest.BuildConfig
import com.cct.sentiatest.data.net.properties.PropertiesApi
import com.cct.sentiatest.ui.utils.addTimeout
import com.google.gson.Gson
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
open class NetworkModule {

    companion object {
        private const val RETROFIT = "Retrofit"
        private const val API_RETROFIT = "ApiRetrofit"
        private const val LOGGING_INTERCEPTOR = "LoggingInterceptor"
        private const val CHUCK_INTERCEPTOR = "ChuckInterceptor"
        private const val CLIENT_RETROFIT = "ClientRetrofit"
    }

    @Provides
    @Named(LOGGING_INTERCEPTOR)
    fun getLogInterceptor(): Interceptor = HttpLoggingInterceptor().apply {
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }

    @Provides
    @Named(CHUCK_INTERCEPTOR)
    fun getChuckInterceptor(context: Context): Interceptor = ChuckInterceptor(context)

    @Provides
    @Named(CLIENT_RETROFIT)
    fun getOkHttpClient(@Named(LOGGING_INTERCEPTOR) logInterceptor: Interceptor,
                        @Named(CHUCK_INTERCEPTOR) chuckInterceptor: Interceptor): OkHttpClient =
            OkHttpClient.Builder()
                    .addInterceptor(logInterceptor)
                    .addInterceptor(chuckInterceptor)
                    .addTimeout()
                    .build()

    @Provides
    @Named(RETROFIT)
    fun providesRetrofit(@Named(CLIENT_RETROFIT) okHttpClient: OkHttpClient): Retrofit.Builder =
            Retrofit.Builder()
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(Gson()))

    @Provides
    @Named(API_RETROFIT)
    fun getApiRetrofit(@Named(RETROFIT) retrofitBuilder: Retrofit.Builder): Retrofit =
            retrofitBuilder.baseUrl(BuildConfig.BASE_URL_API).build()

    @Provides
    fun getPropertiesApi(@Named(API_RETROFIT) retrofit: Retrofit): PropertiesApi =
            retrofit.create(PropertiesApi::class.java)
}