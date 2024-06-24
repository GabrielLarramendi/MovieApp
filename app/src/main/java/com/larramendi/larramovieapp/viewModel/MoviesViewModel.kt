package com.larramendi.larramovieapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.larramendi.larramovieapp.core.Constants
import com.larramendi.larramovieapp.model.entities.Movie
import com.larramendi.larramovieapp.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MoviesViewModel : ViewModel() {

    private var _listMovies = MutableLiveData<List<Movie>>()
    val listMovies : LiveData<List<Movie>> = _listMovies

    fun getPopular() {
        viewModelScope.launch (
            Dispatchers.IO
            ) {
            val response = RetrofitClient.webService.getPopular(Constants.API_KEY)
            withContext(Dispatchers.Main) {
                _listMovies.value = response.body()!!.results.sortedByDescending { it.name.length }
            }
        }
    }

}