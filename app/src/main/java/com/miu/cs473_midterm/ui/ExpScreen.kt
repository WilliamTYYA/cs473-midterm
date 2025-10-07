package com.miu.cs473_midterm.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.miu.cs473_midterm.data.DataSource
import com.miu.lesson5_part2.ui.ExpViewModel

@Composable
fun ExpScreen(modifier: Modifier = Modifier) {
    Scaffold { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
//            val sample = DataSource.loadData()[0]

            val expViewModel: ExpViewModel = viewModel {
                ExpViewModel()
            }
            val counterUIState: ExpUIState by expViewModel.expUIState.collectAsState()

            Image(
                painter = painterResource(id= counterUIState.image.image),
                contentDescription = stringResource(id=counterUIState.image.title),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier= Modifier.padding(5.dp))

            Text(
                text = stringResource(id=counterUIState.image.title)
            )

            Spacer(modifier= Modifier.padding(5.dp))

            Button(
                onClick = {
                    expViewModel.nextImage()
                },
            ) {
                Text(text = "Next")
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ExpScreenPreview() {
    ExpScreen()
}