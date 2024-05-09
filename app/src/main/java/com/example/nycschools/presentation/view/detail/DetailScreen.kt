package com.example.nycschools.presentation.view.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.nycschools.R
import com.example.nycschools.data.model.SATItem
import com.example.nycschools.domain.usecase.UseCase
import com.example.nycschools.presentation.view.common.TitleAndSubtitleRow
import com.example.nycschools.presentation.view.common.TopAppBarView

/**
 * Detail Screen
 *
 * @param satItems - list of [SATItem]
 * @param uniqueSchoolNumber - [String]
 * @param navController - [NavController]
 * */
@Composable
fun DetailScreen(
    satItems: List<SATItem>,
    uniqueSchoolNumber: String,
    navController: NavController,
) {
    val satItem = UseCase().getSatItem(satItems, uniqueSchoolNumber)
    TopAppBarView(
        text = "NYC School Detail",
        imageVector = Icons.Default.ArrowBack,
        contentDescription = "Back",
        onClick = {
            navController.popBackStack()
        },
    ) { modifier ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 4.dp, vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_nyc_detail),
                contentDescription = "Error Image",
                modifier = Modifier.size(200.dp),
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = satItem?.schoolName.orEmpty(),
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                fontStyle = MaterialTheme.typography.titleLarge.fontStyle,
                fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(bottom = 4.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp,
                ),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
            ) {
                TitleAndSubtitleRow(
                    title = "SAT Test Takers #: ",
                    subTitle = satItem?.numOfSatTestTakers.orEmpty(),
                )
                TitleAndSubtitleRow(
                    title = "Avg. Maths Score: ",
                    subTitle = satItem?.satMathAvgScore.orEmpty(),
                )
                TitleAndSubtitleRow(
                    title = "Avg. Writing Score: ",
                    subTitle = satItem?.satWritingAvgScore.orEmpty(),
                )
                TitleAndSubtitleRow(
                    title = "Avg. Critical Reading Score: ",
                    subTitle = satItem?.satCriticalReadingAvgScore.orEmpty(),
                )
            }
        }
    }
}
