package com.tutorial.mylemonade.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tutorial.mylemonade.R
import com.tutorial.mylemonade.ui.theme.MyLemonadeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp(viewModel: LemonadeAppViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.lemonade)) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.clickable {
                    viewModel.clickCount.intValue += 1
                    viewModel.onImageClick()
                                              },
                painter = painterResource(id = viewModel.image.intValue),
                contentDescription = stringResource(id = viewModel.contentDescription.intValue)
            )
            Text(
                modifier = Modifier.padding(16.dp),
                text = stringResource(id = viewModel.userInstructions.intValue)
            )
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun PreviewLemonadeApp() {
    val viewModel = LemonadeAppViewModel()
    MyLemonadeTheme {
        LemonadeApp(viewModel = viewModel)
    }
}