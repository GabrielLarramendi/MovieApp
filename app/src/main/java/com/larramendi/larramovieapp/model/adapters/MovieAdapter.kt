package com.larramendi.larramovieapp.model.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.larramendi.larramovieapp.R
import com.larramendi.larramovieapp.core.Constants
import com.larramendi.larramovieapp.model.entities.Movie
import com.squareup.picasso.Picasso

class MovieAdapter(
    val ctx : Context,
    var moviesList: List<Movie>
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieTitleTxt : TextView = itemView.findViewById(R.id.movieTitleText)
        val moviePoster : ImageView = itemView.findViewById(R.id.moviePosterImg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.movie_item_main_rv, parent, false)
        val viewHolder = ViewHolder(v)
        return viewHolder
    }

    override fun getItemCount(): Int = moviesList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = moviesList[position]

        holder.movieTitleTxt.text = movie.name.toString()
        val moviePosterUrl = Constants.BASE_URL_IMG + movie.poster
        Picasso.get()
            .load(moviePosterUrl)
            .into(holder.moviePoster)

    }
}