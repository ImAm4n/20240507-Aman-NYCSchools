package com.example.nycschools.presentation.view.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Title and Subtitle Row composable
 *
 * @param title - The title of the row
 * @param subTitle - The subtitle of the row
 * */
@Composable
fun TitleAndSubtitleRow(
    title: String,
    subTitle: String,
) {
    Row(
        modifier = Modifier.padding(4.dp),
    ) {
        Text(
            text = title,
            fontStyle = MaterialTheme.typography.bodyMedium.fontStyle,
        )
        Text(
            text = subTitle,
            fontStyle = MaterialTheme.typography.bodyMedium.fontStyle,
        )
    }
}
