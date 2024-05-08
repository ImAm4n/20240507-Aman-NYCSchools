package com.example.nycschools.data.remote

import com.example.nycschools.data.model.SATItem
import com.example.nycschools.data.model.SchoolItem
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * ApiService - Interface for Retrofit API calls
 * */
interface ApiService {
    // get school items from server
    @GET("resource/s3k6-pzi2.json")
    fun getSchoolItems(): Observable<List<SchoolItem>>

    // get sat items from server
    @GET("resource/f9bf-2cp4.json")
    fun getSATItems(): Observable<List<SATItem>>
}