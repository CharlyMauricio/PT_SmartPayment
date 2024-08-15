package com.technical.test.smartpayment.ui.navigations
sealed class NavDestinations(val route: String) {
    data object SplashScreenDest : NavDestinations(route = "splash_screen")
    data object RegisterScreenDest : NavDestinations(route = "register_screen")
    data object ListPlanetScreenDest : NavDestinations(route = "planets_list_screen")
    data object DetailPlanetScreenDest : NavDestinations(route = "planet_detail_screen")
}