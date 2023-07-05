package uz.apexsoftuz.movieskmm.android.presentation.ui.screens.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import coil.compose.AsyncImage
import uz.apexsoftuz.movieskmm.android.presentation.ui.values.CustomColors

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    uiState: DetailScreenState
) {
    Box(contentAlignment = Alignment.Center) {
        uiState.movie?.let { movie ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colors.background)
            ) {
                AsyncImage(
                    model = movie.imageUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .fillMaxWidth()
                        .height(320.dp)
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(16.dp)
                ) {
                    Text(
                        text = movie.title,
                        style = MaterialTheme.typography.h5,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = modifier.height(8.dp))

                    Button(
                        onClick = {},
                        modifier = modifier.fillMaxWidth(),
                        elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(CustomColors.colorMidnightExpress.toColorInt()))
                    ) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = null,
                            tint = White
                        )

                        Spacer(modifier = modifier.width(16.dp))

                        Text(text = "Start watching now", color = White)
                    }

                    Spacer(modifier = modifier.height(8.dp))

                    Text(
                        text = "Released in ${movie.releaseDate}".uppercase(),
                        style = MaterialTheme.typography.overline
                    )

                    Spacer(modifier = modifier.height(4.dp))

                    Text(
                        text = movie.description,
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }

        if (uiState.loading)
            Row(
                modifier = modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) { CircularProgressIndicator(color = Red) }
    }
}