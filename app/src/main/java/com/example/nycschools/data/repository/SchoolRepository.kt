package com.example.nycschools.data.repository

import com.example.nycschools.data.model.SATAPIResponse
import com.example.nycschools.data.model.SchoolAPIResponse
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
    fun getSchoolItems(): Observable<SchoolAPIResponse>

    /**
     * getSATItems - Get SAT Items from server
     *
     * @return Observable<SATAPIResponse>
     * */
    fun getSATItems(): Observable<SATAPIResponse>
}