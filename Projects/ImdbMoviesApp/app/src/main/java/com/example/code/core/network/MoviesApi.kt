package com.example.code.core.network

import com.example.code.models.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MoviesApi {

    companion object {
        private const val MOVIES = "movies.json"
    }

    @GET(MOVIES)
    fun movies(): Call<List<Movie>>

}