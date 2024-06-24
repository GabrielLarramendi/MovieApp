package com.larramendi.larramovieapp.model.entities

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id")
    val id : String,
    @SerializedName("original_title")
    val name : String,
    @SerializedName("poster_path")
    val poster : String
)