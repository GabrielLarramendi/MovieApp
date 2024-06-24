package com.larramendi.larramovieapp.network.response

import com.google.gson.annotations.SerializedName
import com.larramendi.larramovieapp.model.entities.Movie

data class MovieResponse(
    @SerializedName("results")
    var results : List<Movie>
) {

}