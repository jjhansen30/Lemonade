package com.tutorial.mylemonade.ui.screens

import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import com.tutorial.mylemonade.R

class LemonadeAppViewModel : ViewModel() {
    var image: MutableIntState = mutableIntStateOf(R.drawable.lemon_tree)
    var contentDescription: MutableIntState = mutableIntStateOf(R.string.lemonade_tree)
    var userInstructions: MutableIntState = mutableIntStateOf(R.string.lemon_tree_instructions)
    var clickCount: MutableIntState = mutableIntStateOf(0)
    private val imageClickCountRequirement: MutableIntState = mutableIntStateOf((2..6).random())

    fun onImageClick() {
        when (image.intValue) {
            R.drawable.lemon_tree -> {
                image.intValue = R.drawable.lemon_squeeze
                contentDescription.intValue = R.string.lemon_squeeze
                userInstructions.intValue = R.string.lemon_squeeze_instructions
            }
            R.drawable.lemon_squeeze -> {
                if (clickCount.intValue == imageClickCountRequirement.intValue) {
                    image.intValue = R.drawable.lemon_drink
                    contentDescription.intValue = R.string.lemon_drink
                    userInstructions.intValue = R.string.lemon_drink_instructions
                }
            }
            R.drawable.lemon_drink -> {
                image.intValue = R.drawable.lemon_restart
                contentDescription.intValue = R.string.lemon_restart
                userInstructions.intValue = R.string.empty_glass_instructions
            }
            R.drawable.lemon_restart -> {
                image.intValue = R.drawable.lemon_tree
                contentDescription.intValue = R.string.lemonade_tree
                userInstructions.intValue = R.string.lemon_tree_instructions
                clickCount.intValue = 0
                imageClickCountRequirement.intValue = (2..6).random()
            }
        }
    }
}