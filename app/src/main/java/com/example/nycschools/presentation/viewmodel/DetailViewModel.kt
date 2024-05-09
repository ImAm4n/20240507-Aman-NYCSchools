package com.example.nycschools.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.nycschools.data.model.SATItem
import com.example.nycschools.data.repository.SchoolRepository
import com.example.nycschools.util.ApiCallStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * Detail ViewModel class
 * */
@HiltViewModel
class DetailViewModel @Inject constructor(
    private val schoolRepository: SchoolRepository,
): ViewModel() {
    /** mutable state variable for sat items */
    val satItemsList: MutableState<ApiCallStatus<List<SATItem>>> = mutableStateOf(ApiCallStatus.Loading)

    /**
     * function to subscribe to the observer and observe the API response
     * */
    fun getSATItems() {
        schoolRepository.getSATItems()
            .subscribe(object : Observer<List<SATItem>> {
                override fun onSubscribe(d: Disposable) {
                    Log.d("LOGGER onSubscribe", "onSubscribe of loadInitial")
                    satItemsList.value = ApiCallStatus.Loading
                }

                override fun onError(e: Throwable) {
                    Log.d("LOGGER onError", "onError of loadInitial - " + e.message)
                    satItemsList.value = ApiCallStatus.Error(e)
                }

                override fun onComplete() {
                    Log.d("LOGGER onComplete", "onComplete of loadInitial")
                }

                override fun onNext(satItemList: List<SATItem>) {
                    Log.d("LOGGER onNext", "onNext of loadInitial - " + satItemList.first().schoolName)
                    satItemsList.value = ApiCallStatus.Success(satItemList)
                }
            })
    }
}
