package com.example.nycschools.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.nycschools.data.model.SchoolItem
import com.example.nycschools.data.repository.SchoolRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * Home ViewModel class
 * */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val schoolRepository: SchoolRepository,
): ViewModel() {
    // mutable state variable for school items
    val schoolItemsList: MutableState<List<SchoolItem>> = mutableStateOf(emptyList())

    init {
        getSchoolItems()
    }

    private fun getSchoolItems() {
        schoolRepository.getSchoolItems()
            .subscribe(object : Observer<List<SchoolItem>> {
                override fun onSubscribe(d: Disposable) {
                    Log.d("LOGGER onSubscribe", "onSubscribe of loadInitial")
                }

                override fun onError(e: Throwable) {
                    Log.d("LOGGER onError", "onError of loadInitial - " + e.message)
                }

                override fun onComplete() {
                    Log.d("LOGGER onComplete", "onComplete of loadInitial")
                }

                override fun onNext(schoolItemList: List<SchoolItem>) {
                    Log.d("LOGGER onNext", "onNext of loadInitial - " + schoolItemList.first().schoolName)
                    schoolItemsList.value = schoolItemList
                }
            })
    }
}