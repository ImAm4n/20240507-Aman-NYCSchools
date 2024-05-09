package com.example.nycschools.presentation.view.common

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * CircularLoader - contains the circular loader
 * */
@Composable
fun CircularLoader() {
    CircularProgressIndicator(
        modifier = Modifier.size(100.dp),
        color = MaterialTheme.colorScheme.primary,
    )
}