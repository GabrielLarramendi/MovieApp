package com.larramendi.larramovieapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.larramendi.larramovieapp.databinding.ActivityMainBinding
import com.larramendi.larramovieapp.model.adapters.MovieAdapter
import com.larramendi.larramovieapp.viewModel.MoviesViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MoviesViewModel
    private lateinit var moviesAdapter: MovieAdapter
    private lateinit var rvMoviesPopular: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this) [MoviesViewModel::class.java]

        setupRecyclerView()

        viewModel.listMovies.observe(this) {
            moviesAdapter.moviesList = it
            moviesAdapter.notifyDataSetChanged()
        }

        viewModel.getPopular()

    }

    private fun setupRecyclerView() {
        val layoutManager = GridLayoutManager(this, 2)
        binding.moviesMainRecyclerView.layoutManager = layoutManager
        moviesAdapter = MovieAdapter(this, arrayListOf())
        binding.moviesMainRecyclerView.adapter = moviesAdapter
    }
}