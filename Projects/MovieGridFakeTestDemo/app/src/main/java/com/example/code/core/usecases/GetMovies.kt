package com.example.code.core.usecases

import com.example.code.core.interactor.UseCase
import com.example.code.core.repositories.MoviesRepository
import com.example.code.models.Movie
import javax.inject.Inject

/**
 * According to our convention use case must be run in background
 * This use case is run in the background and returns the result
 * **/
class GetMovies
@Inject constructor(private val moviesRepository: MoviesRepository) : UseCase<List<Movie>, UseCase.None>() {

    override suspend fun run(params: None) = moviesRepository.movies()

}