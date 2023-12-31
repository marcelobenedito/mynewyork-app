package com.github.marcelobenedito.mynewyorkcity.data

import com.github.marcelobenedito.mynewyorkcity.data.model.Category
import com.github.marcelobenedito.mynewyorkcity.data.model.Place

data class MyNewYorkUiState(
    val categories: List<Category>,
    val currentSelectedCategory: Category? = null,
    val currentSelectedPlace: Place? = null,
    val isShowingHomeScreen: Boolean = true
)