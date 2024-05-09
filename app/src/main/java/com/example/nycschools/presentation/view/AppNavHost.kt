package com.example.nycschools.presentation.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.nycschools.data.model.SATItem
import com.example.nycschools.presentation.view.detail.DetailScreen
import com.example.nycschools.presentation.view.home.HomeScreen
import com.example.nycschools.presentation.viewmodel.HomeViewModel
import com.example.nycschools.util.NavigationItem

/**
 * AppNavHost - Contains the navigation logic of the app
 *
 * @param modifier - [Modifier]
 * @param navController - [NavHostController]
 * @param startDestination - [String]
 * @param homeViewModel - [HomeViewModel]
 * @param satItems - list of [SATItem]
 * */
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Home.route,
    homeViewModel: HomeViewModel,
    satItems: List<SATItem>,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Home.route) {
            HomeScreen(homeViewModel = homeViewModel, navController = navController, satItems = satItems)
        }
        composable(
            route = NavigationItem.Detail.route + "/{satItemDbn}",
            arguments = listOf(
                navArgument("satItemDbn") {
                    type = NavType.StringType
                    defaultValue = "21K728"
                }
            ),
        ) { entry ->
            DetailScreen(
                satItems = satItems,
                uniqueSchoolNumber = entry.arguments?.getString("satItemDbn").orEmpty(),
                navController = navController,
            )
        }
    }
}
