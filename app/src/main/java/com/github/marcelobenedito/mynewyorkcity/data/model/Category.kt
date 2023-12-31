package com.github.marcelobenedito.mynewyorkcity.data.model

import com.github.marcelobenedito.mynewyorkcity.R

data class Category(
    val name: String,
    val places: List<Place>,
    val imageResourceId: Int = R.drawable.ic_launcher_background
)
