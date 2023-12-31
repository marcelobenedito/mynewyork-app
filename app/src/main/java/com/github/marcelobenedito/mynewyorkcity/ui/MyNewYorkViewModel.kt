package com.github.marcelobenedito.mynewyorkcity.ui

import androidx.lifecycle.ViewModel
import com.github.marcelobenedito.mynewyorkcity.data.MyNewYorkUiState
import com.github.marcelobenedito.mynewyorkcity.data.categories
import com.github.marcelobenedito.mynewyorkcity.data.model.Category
import com.github.marcelobenedito.mynewyorkcity.data.model.Place
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MyNewYorkViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MyNewYorkUiState(categories = categories))
    val uiState: StateFlow<MyNewYorkUiState> = _uiState.asStateFlow()

    fun selectCategory(category: Category) {
        _uiState.update {
            _uiState.value.copy(currentSelectedCategory = category)
        }
    }

    fun selectPlace(place: Place) {
        _uiState.update {
            _uiState.value.copy(currentSelectedPlace = place)
        }
    }
}