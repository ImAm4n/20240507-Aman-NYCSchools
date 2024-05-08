package com.example.nycschools.presentation.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * SchoolCardView - contains the details of respective school
 *
 * @param modifier - Modifier
 * @param schoolName
 * @param email
 * @param website
 * @param phone
 * @param city
 * @param state
 * @param zip
 * */
@Composable
fun SchoolCardView(
    modifier: Modifier = Modifier,
    schoolName: String,
    email: String,
    website: String,
    phone: String,
    city: String,
    state: String,
    zip: String,
) {
    Card(
        modifier = modifier
            .wrapContentSize()
            .padding(bottom = 4.dp)
            .clickable {},
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp,
        ),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
    ) {
        TitleAndSubtitleRow(
            title = "School Name: ",
            subTitle = "Clinton School Writers & Artists, M.S. 260",
        )
        TitleAndSubtitleRow(
            title = "Email: ",
            subTitle = "admissions@theclintonschool.net",
        )
        TitleAndSubtitleRow(
            title = "Website: ",
            subTitle = "www.theclintonschool.net",
        )
        TitleAndSubtitleRow(
            title = "Phone #: ",
            subTitle = "212-524-4360",
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TitleAndSubtitleRow(
                title = "City: ",
                subTitle = "Manhattan",
            )
            Spacer(modifier = Modifier.width(4.dp))
            TitleAndSubtitleRow(
                title = "State: ",
                subTitle = "NY",
            )
            Spacer(modifier = Modifier.width(4.dp))
            TitleAndSubtitleRow(
                title = "Zip: ",
                subTitle = "10003",
            )
        }
    }
}

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
