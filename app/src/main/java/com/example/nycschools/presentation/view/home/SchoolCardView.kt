package com.example.nycschools.presentation.view.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.nycschools.presentation.view.common.TitleAndSubtitleRow
import com.example.nycschools.util.NavigationItem

/**
 * SchoolCardView - contains the details of respective school
 *
 * @param modifier - Modifier
 * @param navController - NavController
 * @param schoolName - String
 * @param email - String
 * @param website - String
 * @param phone - String
 * @param city - String
 * @param state - String
 * @param zip - String
 * @param uniqueSchoolNumber - String
 * */
@Composable
fun SchoolCardView(
    modifier: Modifier = Modifier,
    navController: NavController,
    schoolName: String,
    email: String,
    website: String,
    phone: String,
    city: String,
    state: String,
    zip: String,
    uniqueSchoolNumber: String,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(bottom = 4.dp)
            .clickable {
               navController.navigate(NavigationItem.Detail.withArgs(uniqueSchoolNumber))
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp,
        ),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
    ) {
        TitleAndSubtitleRow(
            title = "School Name: ",
            subTitle = schoolName,
        )
        TitleAndSubtitleRow(
            title = "Email: ",
            subTitle = email,
        )
        TitleAndSubtitleRow(
            title = "Website: ",
            subTitle = website,
        )
        TitleAndSubtitleRow(
            title = "Phone #: ",
            subTitle = phone,
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TitleAndSubtitleRow(
                title = "City: ",
                subTitle = city,
            )
            Spacer(modifier = Modifier.width(4.dp))
            TitleAndSubtitleRow(
                title = "State: ",
                subTitle = state,
            )
        }
        TitleAndSubtitleRow(
            title = "Zip: ",
            subTitle = zip,
        )
    }
}
