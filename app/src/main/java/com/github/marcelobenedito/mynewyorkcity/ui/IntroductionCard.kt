package com.github.marcelobenedito.mynewyorkcity.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.marcelobenedito.mynewyorkcity.R
import com.github.marcelobenedito.mynewyorkcity.ui.theme.MyNewYorkCityTheme

@Composable
fun IntroductionCard(
    text: String,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer
        ),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Lightbulb,
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview(name = "IntroductionCard - Light")
@Composable
fun IntroductionCardLightPreview() {
    MyNewYorkCityTheme {
        Surface {
            IntroductionCard(text = stringResource(id = R.string.home_introduction))
        }
    }
}

@Preview(
    name = "IntroductionCard - Dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun IntroductionCardDarkPreview() {
    MyNewYorkCityTheme {
        Surface {
            IntroductionCard(text = stringResource(id = R.string.home_introduction))
        }
    }
}