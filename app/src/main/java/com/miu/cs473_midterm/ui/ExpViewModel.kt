package com.miu.lesson5_part2.ui

import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.lifecycle.ViewModel
import com.miu.cs473_midterm.data.DataSource
import com.miu.cs473_midterm.model.Item
import com.miu.cs473_midterm.ui.ExpUIState
//import com.miu.lesson5_part2.data.AlphabetData
//import com.miu.lesson5_part2.data.AlphabetRepository
//import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
//import javax.inject.Inject

//@HiltViewModel
//class AlphabetViewModel @Inject constructor (
//    private val alphabetRepository: AlphabetRepository
//): ViewModel() {
class ExpViewModel(
    private val dataSource: List<Item> = DataSource.data
): ViewModel() {
    //    private val alphabetData = AlphabetData.alphabetData
//    private val alphabetData = alphabetRepository.getAlphabetData()

    // create MutableStateFlow
    private val _expUIState = MutableStateFlow(
        ExpUIState(
            image = dataSource[0]
        )
    )

    //Expose it as read only state
    val expUIState = _expUIState.asStateFlow()

    fun nextImage() {
//        val nextAlphabet = alphabetRepository.getNextAlphabet(_alphabetUIState.value.alphabet to _alphabetUIState.value.word)
//        if (nextAlphabet == alphabetData.last()) {
//            _alphabetUIState.update {
//                it.copy(
//                    nextAlphabet.first,
//                    nextAlphabet.second,
//                    isCompleted = true
//                )
//            }
//        } else {
//            _alphabetUIState.update {
//                it.copy(
//                    nextAlphabet.first,
//                    nextAlphabet.second,
//                    isCompleted = false
//                )
//            }
//        }
//        val currentIndex = alphabetData.indexOfFirst { it.first == _alphabetUIState.value.alphabet }
        val currentIndex = dataSource.indexOf(_expUIState.value.image)
        if (currentIndex < dataSource.size - 1) {
            val nextImage = dataSource[currentIndex + 1]
            _expUIState.update {
                it.copy(
                    image = nextImage
                )
            }
        } else {
            _expUIState.update {
                it.copy(
                    image = dataSource[0]
                )
            }
        }

        if (currentIndex == dataSource.size - 2) {
            _expUIState.update {
                it.copy(
                    isCompleted = true
                )
            }
        }
    }
}