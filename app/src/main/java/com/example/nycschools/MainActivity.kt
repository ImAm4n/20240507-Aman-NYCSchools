package com.example.nycschools

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.nycschools.data.model.SATItem
import com.example.nycschools.presentation.view.AppNavHost
import com.example.nycschools.presentation.view.common.CircularLoader
import com.example.nycschools.presentation.view.common.ErrorScreen
import com.example.nycschools.presentation.viewmodel.DetailViewModel
import com.example.nycschools.presentation.viewmodel.HomeViewModel
import com.example.nycschools.ui.theme.NycSchoolsTheme
import com.example.nycschools.util.ApiCallStatus
import dagger.hilt.android.AndroidEntryPoint

/**
 * MainActivity - The entry Point of the app
 * */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    /** HomeViewModel instance */
    private val homeViewModel: HomeViewModel by viewModels()

    /** DetailViewModel instance */
    private val detailViewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailViewModel.getSATItems()
        setContent {
            NycSchoolsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    when (val satItemListStatus = detailViewModel.satItemsList.value) {
                        is ApiCallStatus.Success -> {
                            initViews(satItemListStatus.data)
                            AppNavHost(
                                navController = rememberNavController(),
                                homeViewModel = homeViewModel,
                                satItems = satItemListStatus.data,
                            )
                        }
                        is ApiCallStatus.Error -> {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center,
                            ) {
                                ErrorScreen {
                                    detailViewModel.getSATItems()
                                }
                            }
                        }
                        is ApiCallStatus.Loading -> {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center,
                            ) {
                                CircularLoader()
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * function to initialize the views
     *
     * @param satItems - list of [SATItem]
     * */
    private fun initViews(
        satItems: List<SATItem>,
    ) {
        homeViewModel.getSchoolItems(satItems = satItems)
    }
}
