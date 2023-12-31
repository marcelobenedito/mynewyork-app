package com.github.marcelobenedito.mynewyorkcity.data.model

import androidx.annotation.DrawableRes
import com.github.marcelobenedito.mynewyorkcity.R

data class Place(
    val name: String,
    val address: String,
    val description: String,
    @DrawableRes val imageIdResource: Int = R.drawable.ic_launcher_background
)
