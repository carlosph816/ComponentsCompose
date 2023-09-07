package com.valhasoft.mynewcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

@Composable
fun BasicSlider() {
    var sliderPosition by remember {
        mutableStateOf(0f)
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(value = sliderPosition, onValueChange = {
            sliderPosition = it
        })
        Text(text = sliderPosition.toString())
    }
}

@Composable
fun AdvanceSlider() {
    var sliderPosition by remember {
        mutableStateOf(0f)
    }
    var completeValue by remember {
        mutableStateOf("")
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(value = sliderPosition, onValueChange = {
            sliderPosition = it
        }, valueRange = 0f..10f,
            steps = 9,
            onValueChangeFinished = {
                completeValue = sliderPosition.toString()
            })
        Text(text = completeValue)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyRangeSlider(){
    var recurrentRanger by remember {
        mutableStateOf(0f..10f)
    }
    Column {
        RangeSlider(value = recurrentRanger, onValueChange = {
            recurrentRanger = it
        }, valueRange = 0f..10f, steps = 9)
        Text(text = recurrentRanger.start.toString())
        Text(text = recurrentRanger.endInclusive.toString())

    }

}