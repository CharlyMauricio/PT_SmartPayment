package com.technical.test.smartpayment.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import com.technical.test.smartpayment.ui.utils.composable.EndlessLazyColumn
import com.technical.test.smartpayment.ui.utils.composable.ErrorDialog
import com.technical.test.smartpayment.ui.utils.composable.LoadingScreen
import com.technical.test.smartpayment.ui.utils.composable.TopBarNavigation
import com.technical.test.smartpayment.ui.utils.firstCharUpperCase

@Composable
fun PlanetsListScreen(
    viewModel: MainViewModel,
    onBackClick: () -> Unit,
    onPlanetClicked: (String) -> Unit,
) {
    var page = 1
    val status = viewModel.status.value
    val planetsList = viewModel.planetDataList.collectAsState().value

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    TopBarNavigation(
                        stringResource(id = R.string.app_name),
                        onBackClick,
                    )
                },
                backgroundColor = Color.White,
                contentColor = Color.Black
            )
        }
    ) {
        EndlessLazyColumn(
            modifier = Modifier.padding(it),
            items = planetsList,
            itemContent = { planet ->
                PlanetGridItem(planet, onPlanetClicked)
            },
            loadMore = {
                page += 1
                viewModel.getPlanetList(page)
            }
        )
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
fun PlanetGridItem(planetData: PlanetData, onPlanetClicked: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                onPlanetClicked(planetData.url)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = planetData.name.firstCharUpperCase(),
            color = Color.Black,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
            fontWeight = FontWeight.Black
        )
    }
}
