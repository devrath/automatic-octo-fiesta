package com.example.code.exampleone.screens.lookup

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.code.exampleone.models.EarthImage
import com.example.code.utils.CoroutinesTestRule
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test
import com.example.code.exampleone.network.SpacingOutApi as SpacingOutApi

class LookupViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutineTestRule = CoroutinesTestRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    @Test
    fun `a image is sent through the view after the co-ordinates are entered`() {

        /*** ****************** BLOCK TO MOCK THE API ****************** ***/
        val mockApi = mockk<SpacingOutApi>()
        // Using the mockK object you can mock the kotlin objects and return what you want
        mockkObject(SpacingOutApi)
        // After above step you can check using mocking syntax you can return what you want
        // Now in below line whenever we mock the api, we can ensure we return the mockApi that is needed
        every { SpacingOutApi.create() } returns mockApi
        /*** ****************** BLOCK TO MOCK THE API ****************** ***/

        coEvery { mockApi.getEarthImagery(any(),any()) } answers {
            EarthImage("TestUrl")
        }

        val  viewModel = LookupViewModel()
        viewModel.latLongInput(latitude = 10f,longitude = 10f)

        assertEquals("TestUrl",viewModel.imageLiveData.value)

    }

}