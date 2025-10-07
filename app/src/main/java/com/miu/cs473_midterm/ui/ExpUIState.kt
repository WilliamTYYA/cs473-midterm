package com.miu.cs473_midterm.ui

import com.miu.cs473_midterm.model.Item

data class ExpUIState(
    val image: Item,
    val isCompleted: Boolean = false
)
