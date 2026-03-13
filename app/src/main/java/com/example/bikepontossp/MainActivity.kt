package com.example.bikepontossp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.bikepontossp.navigation.NavGraph
import com.example.bikepontossp.ui.theme.BikePontosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BikePontosTheme {
                NavGraph()
            }
        }
    }
}