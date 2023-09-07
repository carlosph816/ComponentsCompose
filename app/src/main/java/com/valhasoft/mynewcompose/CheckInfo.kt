package com.valhasoft.mynewcompose

data class CheckInfo(val title: String, val isSelected: Boolean, val onSelected: (Boolean) -> Unit)
