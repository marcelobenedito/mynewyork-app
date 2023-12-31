package com.github.marcelobenedito.mynewyorkcity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.github.marcelobenedito.mynewyorkcity.R
import com.github.marcelobenedito.mynewyorkcity.data.MyNewYorkUiState
import com.github.marcelobenedito.mynewyorkcity.ui.theme.MyNewYorkCityTheme
import com.github.marcelobenedito.mynewyorkcity.ui.util.WindowSizeTypeEnum

enum class MyNewYorkCityScreenEnum {
    CATEGORIES, PLACES, DETAILS
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MyNewYorkCityAppBar(
    title: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    if (!canNavigateBack) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_location),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
        },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@Composable
fun MyNewYorkCityApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
    viewModel: MyNewYorkViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val uiState by viewModel.uiState.collectAsState()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = MyNewYorkCityScreenEnum.valueOf(
        backStackEntry?.destination?.route ?: MyNewYorkCityScreenEnum.CATEGORIES.name
    )
    val appBarTitle = when (currentScreen) {
        MyNewYorkCityScreenEnum.CATEGORIES -> stringResource(id = R.string.app_name)
        MyNewYorkCityScreenEnum.PLACES -> uiState.currentSelectedCategory!!.name
        MyNewYorkCityScreenEnum.DETAILS -> uiState.currentSelectedPlace!!.name
    }
    val contentType = when (windowSize) {
        WindowWidthSizeClass.Compact -> WindowSizeTypeEnum.LIST_ONLY
        WindowWidthSizeClass.Medium -> WindowSizeTypeEnum.LIST_ONLY
        WindowWidthSizeClass.Expanded -> WindowSizeTypeEnum.LIST_AND_DETAIL
        else -> WindowSizeTypeEnum.LIST_ONLY
    }

    Scaffold(
        topBar = { MyNewYorkCityAppBar(
            title = appBarTitle,
            canNavigateBack = navController.previousBackStackEntry != null,
            navigateUp = { navController.navigateUp() }
        ) },
        modifier = modifier
    ) { innerPadding ->
        if (contentType == WindowSizeTypeEnum.LIST_AND_DETAIL) {
            MyNewYorkCityAppExpanded(
                uiState = uiState,
                viewModel = viewModel,
                contentPadding = innerPadding
            )
        } else {
            MyNewYorkCityAppCompact(
                uiState = uiState,
                viewModel = viewModel,
                navController = navController,
                contentPadding = innerPadding
            )
        }
    }
}

@Composable
fun MyNewYorkCityAppCompact(
    uiState: MyNewYorkUiState,
    viewModel: MyNewYorkViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    NavHost(
        navController = navController,
        startDestination = MyNewYorkCityScreenEnum.CATEGORIES.name,
        modifier = modifier.padding(contentPadding)
    ) {
        composable(route = MyNewYorkCityScreenEnum.CATEGORIES.name) {
            CategoriesScreen(
                currentSelectedCategory = null,
                categories = uiState.categories,
                onCategoryClicked = {
                    viewModel.selectCategory(it)
                    navController.navigate(MyNewYorkCityScreenEnum.PLACES.name)
                }
            )
        }
        composable(route = MyNewYorkCityScreenEnum.PLACES.name) {
            PlacesScreen(
                currentSelectedPlace = null,
                places = uiState.currentSelectedCategory!!.places,
                onPlaceClicked = {
                    viewModel.selectPlace(it)
                    navController.navigate(MyNewYorkCityScreenEnum.DETAILS.name)
                }
            )
        }
        composable(route = MyNewYorkCityScreenEnum.DETAILS.name) {
            PlaceDetailScreen(place = uiState.currentSelectedPlace!!)
        }
    }
}

@Composable
fun MyNewYorkCityAppExpanded(
    uiState: MyNewYorkUiState,
    viewModel: MyNewYorkViewModel,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    Row(modifier = modifier.padding(contentPadding)) {
        CategoriesScreen(
            currentSelectedCategory = uiState.currentSelectedCategory,
            categories = uiState.categories,
            onCategoryClicked = { viewModel.selectCategory(it) },
            modifier = Modifier.weight(1f)
        )
        PlacesScreen(
            currentSelectedPlace = uiState.currentSelectedPlace,
            places = uiState.currentSelectedCategory?.places ?: emptyList(),
            onPlaceClicked = { viewModel.selectPlace(it) },
            modifier = Modifier.weight(1f)
        )
        PlaceDetailScreen(
            place = uiState.currentSelectedPlace,
            modifier = Modifier.weight(1.5f)
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun NewYorkCityAppCompactPreview() {
    MyNewYorkCityTheme {
        Surface {
            MyNewYorkCityApp(windowSize = WindowWidthSizeClass.Compact)
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.FOLDABLE
)
@Composable
fun NewYorkCityAppMediumPreview() {
    MyNewYorkCityTheme {
        Surface {
            MyNewYorkCityApp(windowSize = WindowWidthSizeClass.Medium)
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.TABLET
)
@Composable
fun NewYorkCityAppExpandedPreview() {
    MyNewYorkCityTheme {
        Surface {
            MyNewYorkCityApp(windowSize = WindowWidthSizeClass.Expanded)
        }
    }
}
