package com.miu.cs473_midterm.data

import com.miu.cs473_midterm.model.Item

interface ExpRepository {
    fun getImageData(): List<Item>
    fun getNextImage(currentImage: Item): Item
}