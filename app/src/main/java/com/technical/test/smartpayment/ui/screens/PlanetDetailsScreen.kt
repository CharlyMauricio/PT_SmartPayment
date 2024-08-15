package com.technical.test.smartpayment.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.technical.test.smartpayment.R
import com.technical.test.smartpayment.api.util.ApiResponseStatus
import com.technical.test.smartpayment.model.PlanetData
import com.technical.test.smartpayment.ui.screens.main.MainViewModel
import com.technical.test.smartpayment.ui.utils.composable.ErrorDialog
import com.technical.test.smartpayment.ui.utils.composable.LoadingScreen
import com.technical.test.smartpayment.ui.utils.composable.TopBarNavigation

@Composable
fun PlanetDetailsScreen(
    viewModel: MainViewModel,
    onBackClick: () -> Unit,
) {
    val status = viewModel.status.value
    val planetData = viewModel.planetData.collectAsState().value

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    TopBarNavigation(
                        planetData.name,
                        onBackClick,
                    )
                },
                backgroundColor = Color.White,
                contentColor = Color.Black
            )
        }
    ) { paddingValues ->
        PlanetItem(paddingValues, planetData)
    }

    when (status) {
        is ApiResponseStatus.Loading -> {
            LoadingScreen()
        }

        is ApiResponseStatus.Error -> {
            ErrorDialog(status.messageId) { }
        }

        else -> {}
    }
}


@Composable
fun PlanetItem(paddingValues: PaddingValues, planetData: PlanetData) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.gravity_format, planetData.gravity),
            color = Color.Black,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
            fontWeight = FontWeight.Black
        )
        Text(
            text = stringResource(R.string.rotation_period_format, planetData.rotationPeriod),
            color = Color.Black,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
            fontWeight = FontWeight.Black
        )
        Text(
            text = stringResource(R.string.orbital_period_period_format, planetData.orbitalPeriod),
            color = Color.Black,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
            fontWeight = FontWeight.Black
        )
        Text(
            text = stringResource(R.string.diameter_format, planetData.diameter),
            color = Color.Black,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
            fontWeight = FontWeight.Black
        )
        Text(
            text = stringResource(R.string.climate_format, planetData.climate),
            color = Color.Black,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
            fontWeight = FontWeight.Black
        )
        Text(
            text = stringResource(R.string.terrain_format, planetData.terrain),
            color = Color.Black,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
            fontWeight = FontWeight.Black
        )
    }
}
