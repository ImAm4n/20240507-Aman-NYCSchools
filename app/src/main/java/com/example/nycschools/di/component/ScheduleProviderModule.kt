package com.example.nycschools.di.component

import com.example.nycschools.util.AppSchedulerProvider
import com.example.nycschools.util.SchedulerProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * ScheduleProviderModule - Module for providing ScheduleProvider dependencies
 * */
@Module
@InstallIn(SingletonComponent::class)
object ScheduleProviderModule {
    /**
     * provideSchedulerProvider - Provide SchedulerProvider
     *
     * @return SchedulerProvider
     * */
    @Provides
    @Singleton
    fun provideAppSchedulerProvider(): SchedulerProvider =
        AppSchedulerProvider()
}
