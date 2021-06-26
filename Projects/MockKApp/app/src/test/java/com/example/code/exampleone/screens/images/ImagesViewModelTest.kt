package com.example.code.exampleone.screens.images

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.code.exampleone.utils.SpacingAnalytics
import com.example.code.exampleone.utils.logEvent
import com.example.code.utils.CoroutinesTestRule
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

class ImagesViewModelTest {

    /**
     * POSSIBLE ERRORS: java.lang.IllegalStateException: Module with the Main dispatcher had failed to initialize.
     * This arises if the coroutine is run in the android main thread
     * **
     * For this we need to provide a test dispatcher for this
     */

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutineTestRule = CoroutinesTestRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    // Sometimes say we are calling a function we want to check that if the method is triggered
    // One classic example is that when we are calling a analytics event and sending one data to the analytics
    @Test
    fun `check if the fetching images event is logged in analytics`() {

        val imageListProvider = mockk<ImageListProvider>()
        val spacingAnalytics = mockk<SpacingAnalytics>()

        // -----------------------------------------> SUT
        ImagesViewModel(imageListProvider,spacingAnalytics)
        // Fetching images is present in the init block so once the constructor is initiated the function is called

        //Now we need to check if the method is called inside
        every { spacingAnalytics.logEvent("Fetching the images") } just Runs

    }

}