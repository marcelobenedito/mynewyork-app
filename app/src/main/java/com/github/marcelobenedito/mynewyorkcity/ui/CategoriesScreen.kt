package com.github.marcelobenedito.mynewyorkcity.ui

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.marcelobenedito.mynewyorkcity.R
import com.github.marcelobenedito.mynewyorkcity.data.categories
import com.github.marcelobenedito.mynewyorkcity.data.model.Category
import com.github.marcelobenedito.mynewyorkcity.ui.theme.MyNewYorkCityTheme

@Composable
fun CategoriesScreen(
    currentSelectedCategory: Category?,
    categories: List<Category>,
    onCategoryClicked: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    CategoriesList(
        currentSelectedCategory = currentSelectedCategory,
        categories = categories,
        onCategoryClicked = onCategoryClicked,
        modifier = modifier.padding(horizontal = 16.dp)
    )
}

@Composable
fun CategoriesList(
    currentSelectedCategory: Category?,
    categories: List<Category>,
    onCategoryClicked: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        item {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = R.string.categories),
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(16.dp))
            IntroductionCard(text = stringResource(id = R.string.home_introduction))
            Spacer(modifier = Modifier.height(16.dp))
        }
        items(categories) { category ->
            MyNewYorkCardItem(
                title = category.name,
                subtitle = category.places.size.toString(),
                image = category.imageResourceId,
                onClick = { onCategoryClicked(category) },
                isSelected = currentSelectedCategory == category,
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(name = "CategoriesScreen - Light")
@Composable
fun CategoriesScreenLightPreview() {
    MyNewYorkCityTheme {
        Surface {
            CategoriesScreen(
                currentSelectedCategory = categories[0],
                categories = categories,
                onCategoryClicked = {}
            )
        }
    }
}

@Preview(
    name = "CategoriesScreen - Dark",
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun CategoriesScreenDarkPreview() {
    MyNewYorkCityTheme {
        Surface {
            CategoriesScreen(
                currentSelectedCategory = categories[0],
                categories = categories,
                onCategoryClicked = {}
            )
        }
    }
}
