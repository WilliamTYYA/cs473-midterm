package com.miu.cs473_midterm.data

import com.miu.cs473_midterm.R
import com.miu.cs473_midterm.model.Item

object DataSource {
    val data = listOf<Item>(
        Item(
            title = R.string.miu_campus,
            image = R.drawable.miu_campus
        ),
        Item(
            title = R.string.rainbow,
            image = R.drawable.rainbow
        ),
        Item(
            title = R.string.sustainable_living_center,
            image = R.drawable.sustainable_living_center
        ),
        Item(
            title = R.string.compro_admission_team,
            image = R.drawable.compro_admission_team
        ),
        Item(
            title = R.string.faculty_student,
            image = R.drawable.faculty_student
        ),
        Item(
            title = R.string.friends,
            image = R.drawable.friends
        ),
        Item(
            title = R.string.miu_snow_fall,
            image = R.drawable.miu_snow_fall
        )
    )
}