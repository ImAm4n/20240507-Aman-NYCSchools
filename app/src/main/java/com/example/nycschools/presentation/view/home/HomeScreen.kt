package com.example.nycschools.presentation.view.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nycschools.presentation.view.common.CircularLoader
import com.example.nycschools.presentation.view.common.ErrorScreen
import com.example.nycschools.presentation.viewmodel.HomeViewModel
import com.example.nycschools.util.ApiCallStatus

/**
 * Home Screen - contains the list of all NYC schools
 *
 * @param modifier - Modifier
 * @param homeViewModel - HomeViewModel
 * */
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel,
) {
    when (val status = homeViewModel.schoolItemsList.value) {
        is ApiCallStatus.Loading -> {
            // Show loading view
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                CircularLoader()
            }
        }
        is ApiCallStatus.Error -> {
            // Show error view
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                ErrorScreen {
                    homeViewModel.getSchoolItems()
                }
            }
        }
        is ApiCallStatus.Success -> {
            // Show success view
            LazyColumn(
                modifier = modifier
                    .fillMaxSize()
                    .padding(horizontal = 4.dp, vertical = 2.dp)
            ) {
                items(
                    items = status.data,
                    key = {
                        it.dbn.orEmpty()
                    }
                ) {
                    SchoolCardView(
                        schoolName = it.schoolName.orEmpty(),
                        email = it.schoolEmail.orEmpty(),
                        website = it.website.orEmpty(),
                        phone = it.phoneNumber.orEmpty(),
                        city = it.city.orEmpty(),
                        state = it.stateCode.orEmpty(),
                        zip = it.zip.orEmpty(),
                    )
                }
            }
        }
    }
}
