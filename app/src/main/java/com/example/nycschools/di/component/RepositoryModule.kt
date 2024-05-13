package com.example.nycschools.di.component

import com.example.nycschools.data.remote.ApiService
import com.example.nycschools.data.repository.SchoolRepository
import com.example.nycschools.data.repository.SchoolRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 *  Repository Module
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    /**
     * function to provide school repo object
     *
     * @param apiService [ApiService]
     * @return SchoolRepositoryImpl
     * */
    @Provides
    @Singleton
    fun providesSchoolRepositoryImpl(
        apiService: ApiService,
    ): SchoolRepository =
        SchoolRepositoryImpl(
            apiService,
        )
}
