package com.example.nycschools.data.repository

import com.example.nycschools.data.model.SATItem
import com.example.nycschools.data.model.SchoolItem
import io.reactivex.Observable

/**
 * SchoolRepository - Repository for School API Response
 * */
interface SchoolRepository {
    /**
     * getSchoolItems - Get School Items from server
     *
     * @return Observable<SchoolAPIResponse>
     * */
    fun getSchoolItems(): Observable<List<SchoolItem>>

    /**
     * getSATItems - Get SAT Items from server
     *
     * @return Observable<SATAPIResponse>
     * */
    fun getSATItems(): Observable<List<SATItem>>
}