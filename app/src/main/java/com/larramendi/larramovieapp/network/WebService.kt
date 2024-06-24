package com.larramendi.larramovieapp.network

import com.larramendi.larramovieapp.network.response.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("popular")
    suspend fun getPopular(
        @Query("api_key") apiKey : String
    ) : Response<MovieResponse>
}