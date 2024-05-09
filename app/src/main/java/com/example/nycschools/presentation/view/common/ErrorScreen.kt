package com.example.nycschools.presentation.view.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nycschools.R

/** ErrorScreen - contains the error view
 *
 * @param onButtonClick - () -> Unit
 * */
@Composable
fun ErrorScreen(
    onButtonClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_error),
            contentDescription = "Error Image",
            modifier = Modifier.size(200.dp),
        )
        Text(
            text = "oops! Something went wrong. Please try again.",
            color = MaterialTheme.colorScheme.error,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 8.dp),
        )
        Spacer(modifier = Modifier.height(4.dp))
        Button(
            onClick = { onButtonClick() },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
        ) {
            Text(
                text = "Try Again",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
            )
        }
    }
}