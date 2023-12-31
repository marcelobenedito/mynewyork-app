package com.github.marcelobenedito.mynewyorkcity.ui

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.marcelobenedito.mynewyorkcity.R
import com.github.marcelobenedito.mynewyorkcity.data.categories
import com.github.marcelobenedito.mynewyorkcity.data.model.Place
import com.github.marcelobenedito.mynewyorkcity.ui.theme.MyNewYorkCityTheme

@Composable
fun PlacesScreen(
    currentSelectedPlace: Place?,
    places: List<Place>,
    onPlaceClicked: (Place) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(horizontal = 16.dp)) {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.places),
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(16.dp))
                IntroductionCard(text = stringResource(R.string.places_introduction))
            }
            items(places) { place ->
                MyNewYorkCardItem(
                    title = place.name,
                    subtitle = place.address,
                    image = place.imageIdResource,
                    isSelected = currentSelectedPlace == place,
                    onClick = { onPlaceClicked(place) }
                )
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Preview(name = "PlacesScreen - Light")
@Composable
fun PlacesScreenLightPreview() {
    MyNewYorkCityTheme {
        Surface {
            PlacesScreen(
                currentSelectedPlace = categories[0].places[0],
                places = categories[0].places,
                onPlaceClicked = {}
            )
        }
    }
}

@Preview(
    name = "PlacesScreen - Dark",
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun PlacesScreenDarkPreview() {
    MyNewYorkCityTheme {
        Surface {
            PlacesScreen(
                currentSelectedPlace = categories[0].places[0],
                places = categories[0].places,
                onPlaceClicked = {}
            )
        }
    }
}
