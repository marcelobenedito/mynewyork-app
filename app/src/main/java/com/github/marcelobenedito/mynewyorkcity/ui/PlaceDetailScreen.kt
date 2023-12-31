package com.github.marcelobenedito.mynewyorkcity.ui

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.marcelobenedito.mynewyorkcity.R
import com.github.marcelobenedito.mynewyorkcity.data.categories
import com.github.marcelobenedito.mynewyorkcity.data.model.Place
import com.github.marcelobenedito.mynewyorkcity.ui.theme.MyNewYorkCityTheme

@Composable
fun PlaceDetailScreen(
    place: Place?,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        val height = LocalConfiguration.current.screenHeightDp.dp
        // calculate 50% of the height screen in dp unit
        val contentHeight = (height.times(50).div(100))
        if (place == null) {
            Column {
                Spacer(modifier = Modifier.height(70.dp))
                IntroductionCard(
                    text = stringResource(R.string.introduction_details),
                    modifier = Modifier.padding(end = 16.dp)
                )
            }
        } else {
            Image(
                painter = painterResource(id = place.imageIdResource),
                contentDescription = place.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(contentHeight)
            )
            PlaceDetailScreenContent(place = place)
        }
    }
}

@Composable
fun PlaceDetailScreenContent(
    place: Place,
    modifier: Modifier = Modifier
) {
    val height = LocalConfiguration.current.screenHeightDp.dp
    // calculate 55% of the height screen in dp unit
    val contentHeight = (height.times(55).div(100))

    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(contentHeight)
                .clip(RoundedCornerShape(34.dp))
                .background(MaterialTheme.colorScheme.surface)
                .padding(16.dp)
        ) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        Icons.Filled.LocationOn,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = place.address,
                        style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.secondary)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.overview),
                    style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = place.description,
                    textAlign = TextAlign.Justify,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.weight(8f)
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1.5f)
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .height(50.dp)
                            .weight(1f)
                    ) {
                        Text(text = stringResource(id = R.string.share))
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    OutlinedButton(
                        onClick = { /*TODO*/ },
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                        modifier = Modifier
                            .height(50.dp)
                            .weight(1f)
                    ) {
                        Text(text = stringResource(id = R.string.get_direction))
                    }
                }
            }
        }
    }
}

@Preview(name = "PlaceDetailScreenContent- Light")
@Composable
fun PlaceDetailScreenContentLightPreview() {
    MyNewYorkCityTheme {
        Surface {
            PlaceDetailScreenContent(place = categories[0].places[0])
        }
    }
}

@Preview(
    name = "PlaceDetailScreenContent- Dark",
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun PlaceDetailScreenContentDarkPreview() {
    MyNewYorkCityTheme {
        Surface {
            PlaceDetailScreenContent(place = categories[0].places[0])
        }
    }
}

@Preview(name = "PlaceDetailScreen - Light")
@Composable
fun PlaceDetailScreenLightPreview() {
    MyNewYorkCityTheme {
        Surface {
            PlaceDetailScreen(place = categories[0].places[0])
        }
    }
}

@Preview(
    name = "PlaceDetailScreen - Dark",
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun PlaceDetailScreenDarkPreview() {
    MyNewYorkCityTheme {
        Surface {
            PlaceDetailScreen(place = categories[0].places[0])
        }
    }
}