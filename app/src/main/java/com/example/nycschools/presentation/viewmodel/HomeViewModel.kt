package com.example.nycschools.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.nycschools.data.model.SATItem
import com.example.nycschools.data.model.SchoolItem
import com.example.nycschools.data.repository.SchoolRepository
import com.example.nycschools.domain.usecase.UseCase
import com.example.nycschools.util.ApiCallStatus
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
    /** mutable state variable for school items */
    val schoolItemsList: MutableState<ApiCallStatus<List<SchoolItem>>> = mutableStateOf(ApiCallStatus.Loading)

    /**
     * function to subscribe to the observer and observe the API response
     *
     * @param satItems - List of [SATItem]
     * */
    fun getSchoolItems(
        satItems: List<SATItem>,
    ) {
        schoolRepository.getSchoolItems()
            .subscribe(object : Observer<List<SchoolItem>> {
                override fun onSubscribe(disposable: Disposable) {
                    // Log.d("LOGGER onSubscribe", "onSubscribe of loadInitial")
                    schoolItemsList.value = ApiCallStatus.Loading
                }

                override fun onNext(schoolItemList: List<SchoolItem>) {
                    // Log.d("LOGGER onNext", "onNext of loadInitial - " + schoolItemList.first().schoolName)
                    val filteredSchoolItemList = UseCase().filterSchoolItems(
                        schoolItems = schoolItemList,
                        satItems = satItems,
                    )
                    schoolItemsList.value = ApiCallStatus.Success(filteredSchoolItemList)
                }

                override fun onError(e: Throwable) {
                    // Log.d("LOGGER onError", "onError of loadInitial - " + e.message)
                    schoolItemsList.value = ApiCallStatus.Error(e)
                }

                override fun onComplete() {
                    // Log.d("LOGGER onComplete", "onComplete of loadInitial")
                }
            })
    }
}
