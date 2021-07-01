package com.example.code.feature

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.code.core.interactor.UseCase
import com.example.code.core.platform.BaseViewModel
import com.example.code.core.usecases.GetMovies
import com.example.code.models.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel
@Inject constructor(private val getMovies: GetMovies) : BaseViewModel() {

    private val _movies: MutableLiveData<List<Movie>> = MutableLiveData()
    val movies: LiveData<List<Movie>> = _movies

    fun loadMovies() = getMovies(UseCase.None(), viewModelScope) {
        it.fold(::handleFailure, ::handleMovieList)
    }

    private fun handleMovieList(movies: List<Movie>) {
        _movies.value = movies
    }

}