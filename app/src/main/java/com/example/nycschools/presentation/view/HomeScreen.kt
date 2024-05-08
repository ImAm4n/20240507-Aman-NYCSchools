package com.example.nycschools.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nycschools.presentation.viewmodel.HomeViewModel

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
    val schoolItem = homeViewModel.schoolItemsList.value
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 4.dp, vertical = 2.dp)
            .verticalScroll(rememberScrollState())
    ) {
        repeat(times = 100) {
            SchoolCardView(
                schoolName = schoolItem.firstOrNull()?.schoolName.orEmpty(),
                email = schoolItem.firstOrNull()?.schoolEmail.orEmpty(),
                website = schoolItem.firstOrNull()?.website.orEmpty(),
                phone = schoolItem.firstOrNull()?.phoneNumber.orEmpty(),
                city = schoolItem.firstOrNull()?.city.orEmpty(),
                state = schoolItem.firstOrNull()?.stateCode.orEmpty(),
                zip = schoolItem.firstOrNull()?.zip.orEmpty(),
            )
        }
    }
}
