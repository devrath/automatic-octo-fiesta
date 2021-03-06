package com.example.code.features.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.code.core.interactor.UseCase
import com.example.code.core.platform.BaseViewModel
import com.example.code.core.usecases.GetMoviesUseCase
import com.example.code.models.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel
@Inject constructor(private val getMoviesUseCase: GetMoviesUseCase) : BaseViewModel() {

    private val _movies: MutableLiveData<List<Movie>> = MutableLiveData()
    val movies: LiveData<List<Movie>> = _movies

    /**
     * We pass two functions, One is the failure from base-view model
     * The other is from the successful movie list response
     */
    fun loadMovies() = getMoviesUseCase(UseCase.None(), viewModelScope) {
        it.fold(::handleFailure, ::handleMovieList)
    }

    private fun handleMovieList(movies: List<Movie>) {
        _movies.value = movies
    }

}