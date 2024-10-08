package com.technical.test.smartpayment.ui.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.technical.test.smartpayment.R
import com.technical.test.smartpayment.api.util.ApiResponseStatus
import com.technical.test.smartpayment.ui.navigations.NavDestinations
import com.technical.test.smartpayment.ui.screens.main.MainViewModel
import com.technical.test.smartpayment.ui.utils.UserStatus
import com.technical.test.smartpayment.ui.utils.composable.ErrorDialog
import com.technical.test.smartpayment.ui.utils.composable.LoadingScreen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    mainViewModel: MainViewModel,
    navController: NavController
) {

    val scaleAnimation: Animatable<Float, AnimationVector1D> =
        remember { Animatable(initialValue = 0f) }

    AnimationSplashContent(
        mainViewModel = mainViewModel,
        scaleAnimation = scaleAnimation,
        navController = navController,
        durationMillisAnimation = 2500,
        delayScreen = 2000L
    )

    DesignSplashScreen(
        imagePainter = painterResource(id =
        R.drawable.splash),
        scaleAnimation = scaleAnimation
    )
}

@Composable
fun AnimationSplashContent(
    mainViewModel: MainViewModel,
    scaleAnimation: Animatable<Float, AnimationVector1D>,
    navController: NavController,
    durationMillisAnimation: Int,
    delayScreen: Long
) {
    LaunchedEffect(key1 = true) {
        scaleAnimation.animateTo(
            targetValue = 0.5F,
            animationSpec = tween(
                durationMillis = durationMillisAnimation,
                easing = {
                    OvershootInterpolator(3F).getInterpolation(it)
                }
            )
        )

        delay(timeMillis = delayScreen)


        when (mainViewModel.userStatus.value) {
            is UserStatus.Exists -> {
                navController.navigate(
                    NavDestinations.ListPlanetScreenDest.route) {
                    popUpTo(NavDestinations.SplashScreenDest.route) {
                        inclusive = true
                    }
                }
            }
            is UserStatus.NoExists -> {
                navController.navigate(
                    NavDestinations.RegisterScreenDest.route) {
                    popUpTo(NavDestinations.SplashScreenDest.route) {
                        inclusive = true
                    }
                }
            }
            else -> {}
        }
    }
}

@Composable
fun DesignSplashScreen(
    modifier: Modifier = Modifier,
    imagePainter: Painter,
    scaleAnimation: Animatable<Float, AnimationVector1D>
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(239, 127, 26),
                        Color(120, 40, 140),
                        Color(0, 47, 187),
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = imagePainter,
                contentDescription = "Logotipo Splash Screen",
                modifier = modifier
                    .size(400.dp)
                    .scale(scale = scaleAnimation.value),
            )
        }
    }
}