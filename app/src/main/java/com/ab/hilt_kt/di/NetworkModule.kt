package com.ab.hilt_kt.di

import com.ab.hilt_kt.data.api.API
import com.ab.hilt_kt.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun retrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }


    @Singleton
    @Provides
    fun api(retrofitBuilder: Retrofit): API {
        return retrofitBuilder.create(API::class.java)
    }
}