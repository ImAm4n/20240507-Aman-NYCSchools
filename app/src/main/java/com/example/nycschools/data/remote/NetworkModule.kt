package com.example.nycschools.data.remote

import com.example.nycschools.util.APIConstants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


/**
 * NetworkModule - Module for providing network dependencies
 * */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideApiInterface(): ApiService {
        val retrofit = getRetrofit(okHttpClient)
        return retrofit.create(ApiService::class.java)
    }

    /** Gson object */
    private var gson: Gson = GsonBuilder()
        .setLenient()
        .excludeFieldsWithoutExposeAnnotation() // configure Gson instance to ignore unknown fields
        .create()

    @Provides
    @Singleton
    fun getRetrofit(okHttpClient: OkHttpClient?): Retrofit {
        return Retrofit.Builder()
            .baseUrl(APIConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient!!)
            .build()
    }

    @JvmStatic
    @get:Singleton
    @get:Provides
    val okHttpClient: OkHttpClient
        get() {
            val okHttpClientBuilder = OkHttpClient.Builder()
            okHttpClientBuilder.connectTimeout(APIConstants.CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
            okHttpClientBuilder.readTimeout(APIConstants.READ_TIMEOUT, TimeUnit.MILLISECONDS)
            okHttpClientBuilder.writeTimeout(APIConstants.WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
            okHttpClientBuilder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            return okHttpClientBuilder.build()
        }
}