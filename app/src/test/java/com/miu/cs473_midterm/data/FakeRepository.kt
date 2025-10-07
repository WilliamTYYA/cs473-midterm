package com.miu.cs473_midterm.data

import com.miu.cs473_midterm.R
import com.miu.cs473_midterm.model.Item

class FakeRepository (
    data: List<Item> = listOf(
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
    )
): ExpRepository by ExpRepositoryImp(data)