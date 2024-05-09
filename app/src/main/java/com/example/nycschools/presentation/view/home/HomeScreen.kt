package com.example.nycschools.presentation.view.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.nycschools.data.model.SATItem
import com.example.nycschools.presentation.view.common.CircularLoader
import com.example.nycschools.presentation.view.common.ErrorScreen
import com.example.nycschools.presentation.view.common.TopAppBarView
import com.example.nycschools.presentation.viewmodel.HomeViewModel
import com.example.nycschools.util.ApiCallStatus

/**
 * Home Screen - contains the list of all NYC schools
 *
 * @param navController - [NavController]
 * @param homeViewModel - [HomeViewModel]
 * @param satItems - list of [SATItem]
 * */
@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel,
    satItems: List<SATItem>,
) {
    TopAppBarView(
        text = "NYC School",
        imageVector = Icons.Default.Home,
        contentDescription = "Home",
    ) { modifier ->
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
                        homeViewModel.getSchoolItems(satItems = satItems)
                    }
                }
            }
            is ApiCallStatus.Success -> {
                // Show success view
                LazyColumn(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(horizontal = 4.dp, vertical = 4.dp)
                ) {
                    items(
                        items = status.data,
                        key = { schoolItem ->
                            schoolItem.dbn.orEmpty()
                        }
                    ) { schoolItem ->
                        SchoolCardView(
                            navController = navController,
                            schoolName = schoolItem.schoolName.orEmpty(),
                            email = schoolItem.schoolEmail ?: "dummy.email.yahoo.com",
                            website = schoolItem.website.orEmpty(),
                            phone = schoolItem.phoneNumber.orEmpty(),
                            city = schoolItem.city.orEmpty(),
                            state = schoolItem.stateCode.orEmpty(),
                            zip = schoolItem.zip.orEmpty(),
                            uniqueSchoolNumber = schoolItem.dbn.orEmpty(),
                        )
                    }
                }
            }
        }
    }
}
