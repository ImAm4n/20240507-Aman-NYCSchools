package com.example.nycschools.data.repository

import com.example.nycschools.data.model.SATItem
import com.example.nycschools.data.model.SchoolItem
import com.example.nycschools.data.remote.ApiService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * SchoolRepositoryImpl - Repository implementation for School
 *
 * @param apiService
 * */
class SchoolRepositoryImpl @Inject constructor(private var apiService: ApiService) : SchoolRepository {
    /**
     * getSchoolItems - Get School Items from server
     *
     * @return Observable<SchoolAPIResponse>
     * */
    override fun getSchoolItems(): Observable<List<SchoolItem>> {
        return apiService
            .getSchoolItems()
            .subscribeOn(Schedulers.io()) // Subscribe on IO thread
            .observeOn(AndroidSchedulers.mainThread()) // Observe on UI thread
    }

    /**
     * getSATItems - Get SAT Items from server
     *
     * @return Observable<SATAPIResponse>
     * */
    override fun getSATItems(): Observable<List<SATItem>> {
        return apiService
            .getSATItems()
            .subscribeOn(Schedulers.io()) // Subscribe on IO thread
            .observeOn(AndroidSchedulers.mainThread()) // Observe on UI thread
    }
}