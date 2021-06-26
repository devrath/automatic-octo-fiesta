package com.example.code.exampleone.screens.images

import com.example.code.exampleone.models.ApodImage
import com.example.code.exampleone.network.SpacingOutApi
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Test
import retrofit2.mock.Calls

@ExperimentalCoroutinesApi
class ImageListProviderTest {

    /**
     * RunBlockingTest is used to ensure that the all the coroutines that are involved
     * in the test are completed before the test finishes
     **/
    @Test
    fun `a list of 30 images is returned from a api service`() = runBlocking {

        // When
        val expectedOutput = 30

        // Since this test needs a api as input - We will use MockK to mock the interface
        val spacingApi = mockk<SpacingOutApi>()
        // Now once the mock is available, we want to ensure its returning the real value that you want it to return when invoked in real code
        // Here in our case when we call the the function the in interface and get the object the function returns
        // Here only the type matters more than the data in it
        // ANSWERS: This will return whatever the block return whenever the block is executed.

        /* every {
            spacingApi.getImage(date = any())
        } answers {
            Calls.response(
                ApodImage(
                    date = "01-01-2020",
                    explanation = "Image is of some response",
                    hdurl = "www.testurl.com",
                    title = "test",
                    url = "www.testurl.com",
                    media_type = "video"
                )
            )
        }*/

        coEvery {
            spacingApi.getImage(date = any())
        } answers {
            ApodImage(
                    date = "01-01-2020",
                    explanation = "Image is of some response",
                    hdurl = "www.testurl.com",
                    title = "test",
                    url = "www.testurl.com",
                    media_type = "video"
            )
        }

        // -----------------------------------------> SUT
        val provider = ImageListProvider(api = spacingApi)
        val images = provider.buildImageList()

        // Then
        assertEquals(expectedOutput,images.size)

    }

}