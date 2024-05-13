package com.example.nycschools.presentation.view.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * TopAppBarView - Contains the top app bar view
 *
 * @param text - [String]
 * @param imageVector - [ImageVector]
 * @param contentDescription - [String]
 * */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarView(
    text: String,
    imageVector: ImageVector,
    contentDescription: String,
    onClick: (() -> Unit)? = null,
    content: @Composable (Modifier) -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = text,
                            fontSize = MaterialTheme.typography.titleMedium.fontSize,
                            fontStyle = MaterialTheme.typography.titleMedium.fontStyle,
                            fontWeight = MaterialTheme.typography.titleMedium.fontWeight,
                            color = MaterialTheme.colorScheme.primary,
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { onClick?.invoke() }) {
                        Icon(
                            imageVector = imageVector,
                            tint = MaterialTheme.colorScheme.primary,
                            contentDescription = contentDescription,
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                )
            )
        }
    ) {
        content(Modifier.padding(it))
    }
}
