package uz.apexsoftuz.movieskmm.android.presentation.ui.screens.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun MovieAppBar(
    modifier: Modifier = Modifier,
    appBarHeight: Dp = 56.dp,
    navigateBackVisible: Boolean,
    currentScreenTitle: String,
    onNavigateBack: () -> Unit,
    elevation: Dp = 12.dp
) {
    Surface(
        elevation = elevation,
        color = Color.White,
        modifier = modifier
            .fillMaxWidth()
            .height(appBarHeight)
    ) {
        Row(
            modifier = modifier.padding(start = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AnimatedVisibility(visible = navigateBackVisible) {
                IconButton(onClick = onNavigateBack) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null,
                        tint = Color.Black
                    )
                }
            }

            Text(
                text = currentScreenTitle,
                style = MaterialTheme.typography.h6,
                modifier = modifier.padding(12.dp),
                color = Color.Black
            )
        }
    }
}