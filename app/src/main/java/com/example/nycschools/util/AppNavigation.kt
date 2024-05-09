package com.example.nycschools.util

/**
 * Screen - Enum class to define the screens in the app
 * */
enum class Screen {
    HOME,
    DETAIL,
}

/**
 * NavigationItem - Sealed class to define the navigation items in the app
 *
 * @param route - [String]
 * */
sealed class NavigationItem(val route: String) {
    object Home : NavigationItem(Screen.HOME.name)
    object Detail : NavigationItem(Screen.DETAIL.name)

    /**
     * getRouteWithArgs - function to get the route with arguments
     *
     * @param args - [String]
     * @return [String]
     * */
    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}