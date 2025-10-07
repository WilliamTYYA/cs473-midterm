package com.miu.cs473_midterm.ui.test

import com.miu.cs473_midterm.R
import com.miu.cs473_midterm.data.FakeRepository
import com.miu.cs473_midterm.ui.ExpViewModel
import org.junit.Before
import org.junit.Test

class ExpViewModelTest {
    // Initialize later
    private lateinit var expViewModel: ExpViewModel

    @Before
    fun setup() {
        expViewModel = ExpViewModel(FakeRepository())
    }

    @Test
    fun testInitialUIState() {
        val uiState = expViewModel.expUIState.value
        assert(uiState.image.image == R.drawable.miu_campus) //true
        assert(uiState.image.title == R.string.miu_campus) //true
    }

    @Test
    fun testAlphabetUIStateAfterNextAlphabet() {
        expViewModel.nextImage()
        val uiState = expViewModel.expUIState.value
        assert(uiState.image.image == R.drawable.rainbow) //true
        assert(uiState.image.title == R.string.rainbow) //true
    }
}