package com.example.code.core.usecases

import androidx.lifecycle.viewModelScope
import com.example.code.base.BaseUnitTest
import com.example.code.core.exception.Failure
import com.example.code.core.functional.Either
import com.example.code.core.interactor.UseCase
import com.example.code.core.network.MoviesApi
import com.example.code.core.platform.FakeNetworkHandler
import com.example.code.core.platform.NetworkHandler
import com.example.code.core.repositories.FakeMoviesRepository
import com.example.code.core.repositories.FakeMoviesRepositoryCases
import com.example.code.core.repositories.MoviesRepository
import com.example.code.core.services.FakeMoviesService
import com.example.code.core.services.MoviesService
import com.example.code.models.Movie
import com.nhaarman.mockitokotlin2.mock
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Call
import retrofit2.Retrofit


@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class GetMoviesUseCaseTest : BaseUnitTest() {

    @Test
    fun `test for successful movies list retrieval from web service`() = runBlocking{

        val fakeRepo = FakeMoviesRepository(
            FakeNetworkHandler(mock{},isNetAvailable = true),
            FakeMoviesService(),
            FakeMoviesRepositoryCases.MOVIE_LIST)

        val useCase = GetMoviesUseCase(fakeRepo)

        useCase(UseCase.None(), this) {
            assertTrue(it.isRight)
        }
    }


    @Test
    fun `test for empty movies list retrieval from web service`() = runBlocking{

        val fakeRepo = FakeMoviesRepository(
            FakeNetworkHandler(mock{},isNetAvailable = true),
            FakeMoviesService(),
            FakeMoviesRepositoryCases.EMPTY_MOVIE_LIST)

        val useCase = GetMoviesUseCase(fakeRepo)

        useCase(UseCase.None(), this) {
            assertTrue(it.isRight)
        }
    }


    @Test
    fun `test for error in connectivity`() = runBlocking{

        val fakeRepo = FakeMoviesRepository(
            FakeNetworkHandler(mock{},isNetAvailable = false),
            FakeMoviesService(),
            FakeMoviesRepositoryCases.FAILURE_CONNECTIVITY)

        val useCase = GetMoviesUseCase(fakeRepo)

        useCase(UseCase.None(), this) {
            assertTrue(it.isLeft)
        }
    }


    @Test
    fun `test for error in server`() = runBlocking{

        val fakeRepo = FakeMoviesRepository(
            FakeNetworkHandler(mock{},isNetAvailable = true),
            FakeMoviesService(),
            FakeMoviesRepositoryCases.FAILURE_SERVER_ERROR)

        val useCase = GetMoviesUseCase(fakeRepo)

        useCase(UseCase.None(), this) {
            assertTrue(it.isLeft)
        }
    }


}

