package com.miu.cs473_midterm.data

import com.miu.cs473_midterm.model.Item

class ExpRepositoryImp(
    private val imageData: List<Item> = DataSource.data
): ExpRepository {
    override fun getImageData(): List<Item> = imageData

    override fun getNextImage(currentImage: Item): Item {
        val imageData = getImageData()
        val currentIndex = imageData.indexOf(currentImage)
        if (currentIndex < imageData.size - 1) {
            return imageData[currentIndex + 1]
        } else {
            return imageData.first()
        }
    }
}