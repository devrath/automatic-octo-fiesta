package com.example.code.core.repositories

import com.example.code.core.exception.Failure
import com.example.code.core.functional.Either
import com.example.code.core.platform.FakeNetworkHandler
import com.example.code.core.services.FakeMoviesService
import com.example.code.models.Movie

enum class FakeMoviesRepositoryCases { MOVIE_LIST, EMPTY_MOVIE_LIST, FAILURE_SERVER_ERROR, FAILURE_CONNECTIVITY }

class FakeMoviesRepository constructor(
    private val networkHandler: FakeNetworkHandler,
    private val service: FakeMoviesService,
    private val cases: FakeMoviesRepositoryCases
) : MoviesRepository {

    private var movieList = listOf(Movie(1,"SomeUrl"))

    override fun movies(): Either<Failure, List<Movie>> {

        return if(!networkHandler.isNetworkAvailable()){
            Either.Left(Failure.NetworkConnection)
        }else{
            when (cases){
                FakeMoviesRepositoryCases.EMPTY_MOVIE_LIST -> Either.Right(emptyList())
                FakeMoviesRepositoryCases.MOVIE_LIST -> Either.Right(movieList)
                FakeMoviesRepositoryCases.FAILURE_CONNECTIVITY -> Either.Left(Failure.NetworkConnection)
                FakeMoviesRepositoryCases.FAILURE_SERVER_ERROR -> Either.Left(Failure.ServerError)
            }
        }
    }
}