package com.lucasmendes.wallapp.framework.network.api

import com.lucasmendes.wallapp.framework.network.response.DataWrapperResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WallpapersApi {
    @GET("v1/curated")
    suspend fun getPopularWallpaper(
        @Query("page") page:Int,
        @Query("per_page") perPage:Int
    ) : DataWrapperResponse
}
