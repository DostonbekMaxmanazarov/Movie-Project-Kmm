package uz.apexsoftuz.movieskmm.android.presentation.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.*
import com.google.accompanist.systemuicontroller.*
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import uz.apexsoftuz.movieskmm.android.presentation.ui.screens.common.Detail
import uz.apexsoftuz.movieskmm.android.presentation.ui.screens.home.HomeScreen
import uz.apexsoftuz.movieskmm.android.presentation.ui.screens.home.HomeViewModel
import uz.apexsoftuz.movieskmm.android.presentation.ui.screens.common.Home
import uz.apexsoftuz.movieskmm.android.presentation.ui.screens.common.MovieAppBar
import uz.apexsoftuz.movieskmm.android.presentation.ui.screens.common.movieDestinations
import uz.apexsoftuz.movieskmm.android.presentation.ui.screens.detail.DetailScreen
import uz.apexsoftuz.movieskmm.android.presentation.ui.screens.detail.DetailViewModel

@Composable
fun MainScreen() {
    val isSystemDark = isSystemInDarkTheme()
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val systemUiController = rememberSystemUiController()
    val statusBarColor = if (isSystemDark) MaterialTheme.colors.primaryVariant
    else Color.White

    SideEffect { systemUiController.setStatusBarColor(statusBarColor, darkIcons = !isSystemDark) }

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = movieDestinations.find { destination ->
        backStackEntry?.destination?.route == destination.route || backStackEntry?.destination?.route == destination.routeWithArgs
    } ?: Home

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MovieAppBar(
                currentScreenTitle = currentScreen.title,
                onNavigateBack = { navController.navigateUp() },
                navigateBackVisible = navController.previousBackStackEntry != null
            )
        }
    ) { innerPaddings ->
        NavHost(
            navController = navController,
            modifier = Modifier.padding(innerPaddings),
            startDestination = Home.routeWithArgs
        ) {
            composable(Home.routeWithArgs) {
                val homeViewModel: HomeViewModel = koinViewModel()
                HomeScreen(
                    uiState = homeViewModel.uiState,
                    loadNextMovies = { loadNext -> homeViewModel.loadMovies(reload = loadNext) },
                    navigateToDetail = { navController.navigate("${Detail.route}/${it.id}") }
                )
            }

            composable(Detail.routeWithArgs, arguments = Detail.arguments) { navBackStack ->
                val moveId = navBackStack.arguments?.getInt("movieId") ?: 0
                val detailViewModel: DetailViewModel = koinViewModel(
                    parameters = { parametersOf(moveId) }
                )
                DetailScreen(uiState = detailViewModel.uiState)
            }
        }
    }
}