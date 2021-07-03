package com.example.code.core.usecases

import com.example.code.base.BaseUnitTest
import com.example.code.core.exception.Failure
import com.example.code.core.functional.Either
import com.example.code.core.network.MoviesApi
import com.example.code.core.platform.NetworkHandler
import com.example.code.core.repositories.MoviesRepository
import com.example.code.core.services.MoviesService
import com.example.code.models.Movie
import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.ExperimentalCoroutinesApi
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Call
import retrofit2.Retrofit


@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class GetMoviesUseCaseTest : BaseUnitTest() {


    @Before
    fun init() {

    }

    @Test
    fun `test for successful movies list retrieval from web service`() {

    }

}

/*
class FakeMoviesRepository : MoviesRepository.Network(FakeNetworkHandler(), FakeMoviesService()){

    override fun movies() : Either<Failure, List<Movie>> {
        return Either.Left(Failure.NetworkConnection)
    }

}

class FakeNetworkHandler : NetworkHandler(context = mock { }) {
    override fun isNetworkAvailable(): Boolean {
        return true
    }
}

class FakeMoviesService : MoviesService(retrofit = mock { }) {

    var retrofit : Retrofit = retrofit

    override fun movies() {
        val mockWebServer = MockWebServer()

        retr

    }
}

class FakeMoviesApi : MoviesApi {
    override fun movies(): Call<List<Movie>> {
       return listOf(movie, movie)
    }
}
*/

val movie = Movie(id = 1, poster = "Some Url Id")


