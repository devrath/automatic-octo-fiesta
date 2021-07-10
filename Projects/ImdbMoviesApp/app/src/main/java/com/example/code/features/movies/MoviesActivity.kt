package com.example.code.features.movies

import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.StringRes
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.code.R
import com.example.code.core.exception.Failure
import com.example.code.core.extension.failure
import com.example.code.core.extension.observe
import com.example.code.core.platform.BaseActivity
import com.example.code.databinding.ActivityMainBinding
import com.example.code.models.Movie
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MoviesActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {


    @Inject
    lateinit var moviesAdapter: MoviesAdapter
    private val moviesViewModel: MoviesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeView()
        loadMoviesList()
        with(moviesViewModel) {
            observe(movies, ::renderMoviesList)
            failure(failure, ::handleFailure)
        }
    }

    private fun initializeView() {
        binding.movieList.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        binding.movieList.adapter = moviesAdapter
    }

    private fun loadMoviesList() {
        moviesViewModel.loadMovies()
    }

    private fun renderMoviesList(movies: List<Movie>?) {
        moviesAdapter.collection = movies.orEmpty()
    }

    private fun handleFailure(failure: Failure?) {
        when (failure) {
            is Failure.NetworkConnection -> renderFailure(R.string.failure_network_connection)
            is Failure.ServerError -> renderFailure(R.string.failure_server_error)
            else -> renderFailure(R.string.failure_server_error)
        }
    }

    private fun renderFailure(@StringRes message: Int) {
        notifyWithAction(binding.movieList,message, R.string.action_refresh, ::loadMoviesList)
    }

}