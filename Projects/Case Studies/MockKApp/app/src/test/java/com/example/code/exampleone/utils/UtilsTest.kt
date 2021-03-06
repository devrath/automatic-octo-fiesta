package com.example.code.exampleone.utils

import androidx.lifecycle.ViewModel
import io.mockk.mockkConstructor
import io.mockk.verify
import org.junit.Test

class UtilsTest {
    @Test
    fun `the log event extension logs the provided event`() {
        mockkConstructor(SpacingAnalytics::class)
        val viewModel = object : ViewModel() {}

        viewModel.logEvent("Test Event")

        verify { anyConstructed<SpacingAnalytics>().logEvent("Test Event", mapOf("Logging View Model" to viewModel::class.java.simpleName)) }
    }
}