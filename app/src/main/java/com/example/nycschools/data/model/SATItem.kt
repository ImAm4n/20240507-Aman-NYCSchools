package com.example.nycschools.data.model

import com.google.gson.annotations.SerializedName

/**
 * SATItem - Data class for SAT Item
 * */
data class SATItem(
    @SerializedName("dbn")
    val dbn: String?,
    @SerializedName("num_of_sat_test_takers")
    val numOfSatTestTakers: String?,
    @SerializedName("sat_critical_reading_avg_score")
    val satCriticalReadingAvgScore: String?,
    @SerializedName("sat_math_avg_score")
    val satMathAvgScore: String?,
    @SerializedName("sat_writing_avg_score")
    val satWritingAvgScore: String?,
    @SerializedName("school_name")
    val schoolName: String?
)