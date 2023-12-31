package com.github.marcelobenedito.mynewyorkcity.ui

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.marcelobenedito.mynewyorkcity.R
import com.github.marcelobenedito.mynewyorkcity.ui.theme.MyNewYorkCityTheme
import com.github.marcelobenedito.mynewyorkcity.ui.theme.selected_card

@Composable
fun MyNewYorkCardItem(
    title: String,
    subtitle: String,
    image: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) selected_card else MaterialTheme.colorScheme.secondaryContainer
        ),
        shape = RoundedCornerShape(15.dp),
        modifier = modifier
            .clip(RoundedCornerShape(15.dp))
            .clickable { onClick() }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = image),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 16.dp)
                    .size(80.dp)
                    .clip(RoundedCornerShape(15.dp))
            )
            Column(modifier = Modifier.weight(2f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onSurface),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = subtitle,
                    style = if (subtitle.length > 4) MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.onSurface) else MaterialTheme.typography.displaySmall.copy(color = MaterialTheme.colorScheme.onSurface),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Column(
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
            ) {
                Box(modifier = Modifier
                    .clip(RoundedCornerShape(25.dp))
                    .background(MaterialTheme.colorScheme.primary)
                    .size(24.dp)
                    .padding(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowForward,
                        tint = MaterialTheme.colorScheme.onPrimary,
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Preview(name = "MyNewYorkCardItem - Light")
@Composable
fun MyNewYorkCardItemLightPreview() {
    MyNewYorkCityTheme {
        Surface {
            MyNewYorkCardItem(
                title = "Coffee Shop",
                subtitle = "31",
                image = R.drawable.ic_launcher_background,
                onClick = {}
            )
        }
    }
}

@Preview(
    name = "MyNewYorkCardItem - Dark",
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun MyNewYorkCardItemDarkPreview() {
    MyNewYorkCityTheme {
        Surface {
            MyNewYorkCardItem(
                title = "Coffee Shop",
                subtitle = "31",
                image = R.drawable.ic_launcher_background,
                onClick = {}
            )
        }
    }
}
