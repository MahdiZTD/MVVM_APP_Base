package com.visally.showme.infrustructure.network

import com.visally.showme.infrustructure.data.remote.ApiEndPoint
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import okhttp3.logging.HttpLoggingInterceptor



class RetrofitRepository  {
    private val defaultOkHttpRequestTimeoutSeconds = 50L
    private val defaultOkHttpResponseTimeoutSeconds = 50L
    private val defaultOkHttpTimeoutSeconds = 50L


    fun getForSquareRetrofit():Retrofit{

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val httpClient =OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .readTimeout(defaultOkHttpRequestTimeoutSeconds, TimeUnit.SECONDS)
                .writeTimeout(defaultOkHttpResponseTimeoutSeconds, TimeUnit.SECONDS)
                .connectTimeout(defaultOkHttpTimeoutSeconds, TimeUnit.SECONDS)
                .build()

        return Retrofit.Builder()
                .baseUrl(ApiEndPoint.ENDPOINT_NEWS)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
}