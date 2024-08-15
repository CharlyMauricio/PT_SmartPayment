package com.technical.test.smartpayment.ui.screens.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.technical.test.smartpayment.ui.navigations.NavigationScreen
import com.technical.test.smartpayment.ui.theme.SmartPaymentTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartPaymentTheme {
                NavigationScreen(
                    onBackClick = { finish() }
                )
            }
        }
    }
}