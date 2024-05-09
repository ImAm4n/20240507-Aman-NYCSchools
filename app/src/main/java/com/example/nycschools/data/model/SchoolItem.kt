package com.example.nycschools.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * SchoolItem - Data class for the School Item
 * */
@Keep
data class SchoolItem(
    @Expose @SerializedName("city")
    val city: String?,
    @Expose @SerializedName("dbn")
    val dbn: String?,
    @Expose @SerializedName("phone_number")
    val phoneNumber: String?,
    @Expose @SerializedName("school_email")
    val schoolEmail: String?,
    @Expose @SerializedName("school_name")
    val schoolName: String?,
    @Expose @SerializedName("state_code")
    val stateCode: String?,
    @Expose @SerializedName("website")
    val website: String?,
    @Expose @SerializedName("zip")
    val zip: String?
)