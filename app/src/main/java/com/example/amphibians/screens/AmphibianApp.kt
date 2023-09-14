package com.example.amphibians.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibians.R
import com.example.amphibians.model.Amphibian
import com.example.amphibians.ui.theme.AmphibiansTheme

@Composable
fun AmphibianApp(
    amphibianUiState: AmphibianUiState
){
    when(amphibianUiState) {
        is AmphibianUiState.Loading -> LoadingScreen()
        is AmphibianUiState.Success -> AmphibianList(amphibianUiState.amphibianList)
        is AmphibianUiState.Error -> ErrorScreen()
    }
}

@Composable
fun AmphibianList(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(4.dp)
    ){

    }
}

@Composable
fun AmphibianCard(photo: Amphibian, modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSecondary),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(photo.imgSrc)
                .crossfade(true)
                .build(),
            error = painterResource(R.drawable.network_error_has_occured2),
            placeholder = stringResource(R.drawable)
        )
    }
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.network_error_has_occured2),
        contentDescription = stringResource(R.string.network_error),
        modifier = modifier.fillMaxSize()
    )
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        CircularProgressIndicator(
            modifier = modifier.size(68.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorScreenPreview(){
    AmphibiansTheme {
        ErrorScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingScreenPreview(){
    AmphibiansTheme {
        LoadingScreen()
    }
}
