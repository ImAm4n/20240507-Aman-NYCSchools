package com.example.nycschools.util

/**
 * ApiCallStatus - sealed class for handling API call status
 * */
sealed class ApiCallStatus<out T> {
    /** Success - data class for success response */
    data class Success<out T>(val data: T) : ApiCallStatus<T>()

    /** Error - data class for error response */
    data class Error(val exception: Throwable) : ApiCallStatus<Nothing>()

    /** Loading - object for loading status */
    object Loading : ApiCallStatus<Nothing>()
}