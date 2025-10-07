package com.miu.cs473_midterm.ui

import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.lifecycle.ViewModel
import com.miu.cs473_midterm.data.DataSource
import com.miu.cs473_midterm.data.ExpRepository
import com.miu.cs473_midterm.model.Item
import com.miu.cs473_midterm.ui.ExpUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ExpViewModel @Inject constructor (
    private val expRepository: ExpRepository
): ViewModel() {
    private val imageData = expRepository.getImageData()

    // create MutableStateFlow
    private val _expUIState = MutableStateFlow(
        ExpUIState(
            image = imageData[0]
        )
    )

    //Expose it as read only state
    val expUIState = _expUIState.asStateFlow()

    fun nextImage() {
        val nextImage = expRepository.getNextImage(_expUIState.value.image)
        if (nextImage == imageData.last()) {
            _expUIState.update {
                it.copy(
                    nextImage,
                    true
                )
            }
        } else {
            _expUIState.update {
                it.copy(
                    nextImage,
                    false
                )
            }
        }
    }
}