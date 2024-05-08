package com.example.nycschools

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import com.example.nycschools.presentation.view.HomeScreen
import com.example.nycschools.presentation.viewmodel.HomeViewModel
import com.example.nycschools.ui.theme.NycSchoolsTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * MainActivity - The entry Point of the app
 * */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val homeViewModel: HomeViewModel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NycSchoolsTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        text = "NYC School",
                                        fontSize = MaterialTheme.typography.titleMedium.fontSize,
                                        fontStyle = MaterialTheme.typography.titleMedium.fontStyle,
                                        fontWeight = MaterialTheme.typography.titleMedium.fontWeight,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                }
                            },
                            navigationIcon = {
                                IconButton(onClick = {}) {
                                    Icon(
                                        imageVector = Icons.Filled.Home,
                                        tint = MaterialTheme.colorScheme.primary,
                                        contentDescription = "Home"
                                    )
                                }
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                            )
                        )
                    }
                ) {
                    HomeScreen(
                        modifier = Modifier.padding(it),
                        homeViewModel = homeViewModel,
                    )
                }
            }
        }
    }
}
