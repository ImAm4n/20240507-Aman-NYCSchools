package com.example.nycschools.data.repository

import com.example.nycschools.data.model.SATItem
import com.example.nycschools.data.model.SchoolItem
import com.example.nycschools.data.remote.ApiService
import com.example.nycschools.util.AppSchedulerProvider
import com.example.nycschools.util.SchedulerProvider
import io.reactivex.Observable
import javax.inject.Inject

/**
 * SchoolRepositoryImpl - Repository implementation for School
 *
 * @param apiService
 * */
class SchoolRepositoryImpl @Inject constructor(
    private var apiService: ApiService,
    private var schedulerProvider: SchedulerProvider = AppSchedulerProvider(),
) : SchoolRepository {
    /**
     * getSchoolItems - Get School Items from server
     *
     * @return Observable<SchoolAPIResponse>
     * */
    override fun getSchoolItems(): Observable<List<SchoolItem>> {
        return apiService
            .getSchoolItems()
            .subscribeOn(schedulerProvider.io()) // Subscribe on IO thread
            .observeOn(schedulerProvider.ui()) // Observe on UI thread
    }

    /**
     * getSATItems - Get SAT Items from server
     *
     * @return Observable<SATAPIResponse>
     * */
    override fun getSATItems(): Observable<List<SATItem>> {
        return apiService
            .getSATItems()
            .subscribeOn(schedulerProvider.io()) // Subscribe on IO thread
            .observeOn(schedulerProvider.ui()) // Observe on UI thread
    }
}
