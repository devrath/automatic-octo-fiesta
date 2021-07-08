package com.example.code.core.services

import com.example.code.core.network.MoviesApi
import com.example.code.models.Movie
import com.nhaarman.mockitokotlin2.mock
import retrofit2.Call

class FakeMoviesService : MoviesApi {

    private var movieList = listOf(Movie(1,""))

    override fun movies(): Call<List<Movie>> {
        return mock { movieList }
    }
}