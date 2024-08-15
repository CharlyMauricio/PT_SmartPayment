package com.technical.test.smartpayment.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.technical.test.smartpayment.R
import com.technical.test.smartpayment.ui.navigations.NavDestinations
import com.technical.test.smartpayment.ui.screens.main.MainViewModel
import com.technical.test.smartpayment.ui.utils.composable.AuthField
import com.technical.test.smartpayment.ui.utils.composable.SpinnerScreen
import com.technical.test.smartpayment.ui.utils.getListCountry

@Composable
fun RegisterScreen(
    viewModel: MainViewModel,
    navController: NavController
) {

    val name = remember { mutableStateOf("") }
    val surnamePaternal = remember { mutableStateOf("") }
    val surnameMaternal = remember { mutableStateOf("") }
    val birthdate = remember { mutableStateOf("") }
    val country = remember { mutableStateOf(getListCountry()[0]) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 32.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AuthField(
            label = stringResource(id = R.string.name_input),
            modifier = Modifier
                .fillMaxWidth(),
            input = name.value,
            onTextChanged = {
                name.value = it
            },
        )

        AuthField(
            label = stringResource(id = R.string.surname_paternal_input),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            input = surnamePaternal.value,
            onTextChanged = {
                surnamePaternal.value = it
            }
        )

        AuthField(
            label = stringResource(id = R.string.surname_maternal_input),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            input = surnameMaternal.value,
            onTextChanged = {
                surnameMaternal.value = it
            }
        )

        AuthField(
            label = stringResource(id = R.string.birthdate_input),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            input = birthdate.value,
            onTextChanged = {
                birthdate.value = it
            }
        )

        SpinnerScreen(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            dropDownModifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            items = getListCountry(),
            selectedItem = country.value,
            onItemSelected = { country.value = it },
            selectedItemFactory = { modifier, item ->
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = modifier
                        .padding(8.dp)
                        .wrapContentSize()
                ) {
                    Text(item, modifier = Modifier.weight(1f))
                }
            },
            dropdownItemFactory = { item, _ ->
                Text(text = item)
            }
        )

        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .semantics { testTag = "sign-up-button" },
            onClick = {
                viewModel.addUserDB(
                    name.value,
                    surnamePaternal.value,
                    surnameMaternal.value,
                    birthdate.value,
                    country.value
                )
                navController.navigate(
                    NavDestinations.ListPlanetScreenDest.route) {
                    popUpTo(NavDestinations.RegisterScreenDest.route) {
                        inclusive = true
                    }
                }
            }) {
            Text(
                stringResource(R.string.register_btn),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium
            )
        }
    }
}