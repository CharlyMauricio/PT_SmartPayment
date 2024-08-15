package com.technical.test.smartpayment.ui.navigations

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.technical.test.smartpayment.ui.screens.main.MainViewModel
import com.technical.test.smartpayment.ui.screens.PlanetDetailsScreen
import com.technical.test.smartpayment.ui.screens.PlanetsListScreen
import com.technical.test.smartpayment.ui.screens.RegisterScreen
import com.technical.test.smartpayment.ui.screens.SplashScreen
import com.technical.test.smartpayment.ui.utils.getIdPlanet

@Composable
fun NavigationScreen(
    onBackClick: () -> Unit,
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        onBackClick = { onBackClick() },
        mainViewModel = mainViewModel,
    )
}

@Composable
private fun NavHost(
    navController: NavHostController,
    onBackClick: () -> Unit,
    mainViewModel: MainViewModel
) {
    NavHost(
        navController = navController,
        startDestination = NavDestinations.SplashScreenDest.route
    ) {
        composable(route = NavDestinations.SplashScreenDest.route) {
            SplashScreen(
                mainViewModel,
                navController
            )
        }

        composable(route = NavDestinations.RegisterScreenDest.route) {
            RegisterScreen(
                mainViewModel,
                navController
            )
        }

        composable(route = NavDestinations.ListPlanetScreenDest.route) {
            PlanetsListScreen(
                mainViewModel,
                onBackClick = { onBackClick() },
                onPlanetClicked = {
                    mainViewModel.getPlanetData(it.getIdPlanet())
                    navController.navigate(route = NavDestinations.DetailPlanetScreenDest.route)
                }
            )
        }

        composable(route = NavDestinations.DetailPlanetScreenDest.route) {
            PlanetDetailsScreen(
                mainViewModel,
                onBackClick = { navController.navigateUp() }
            )
        }
    }
}