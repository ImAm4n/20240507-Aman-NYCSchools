package com.example.nycschools.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * SATItem - Data class for SAT Item
 * */
data class SATItem(
    @Expose @SerializedName("dbn")
    val dbn: String?,
    @Expose @SerializedName("num_of_sat_test_takers")
    val numOfSatTestTakers: String?,
    @Expose @SerializedName("sat_critical_reading_avg_score")
    val satCriticalReadingAvgScore: String?,
    @Expose @SerializedName("sat_math_avg_score")
    val satMathAvgScore: String?,
    @Expose @SerializedName("sat_writing_avg_score")
    val satWritingAvgScore: String?,
    @Expose @SerializedName("school_name")
    val schoolName: String?
)