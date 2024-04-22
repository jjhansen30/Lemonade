package com.tutorial.mylemonade.ui.screens

import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import com.tutorial.mylemonade.R

class LemonadeAppViewModel : ViewModel() {
    var image: MutableIntState = mutableIntStateOf(R.drawable.lemon_tree)
    var contentDescription: MutableIntState = mutableIntStateOf(R.string.lemonade_tree)
    var userInstructions: MutableIntState = mutableIntStateOf(R.string.tap_lemon_tree)

    fun onImageClick() {
        TODO()
    }
}