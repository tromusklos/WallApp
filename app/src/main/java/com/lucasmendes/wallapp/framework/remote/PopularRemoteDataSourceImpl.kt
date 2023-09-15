package com.lucasmendes.wallapp.framework.remote

import com.lucasmendes.core.data.repository.PopularRemoteDataSrc
import com.lucasmendes.wallapp.framework.network.api.WallparpersApi
import com.lucasmendes.wallapp.framework.network.response.DataWrapperResponse

class PopularRemoteDataSourceImpl(
    private val api: WallparpersApi
): PopularRemoteDataSrc<DataWrapperResponse> {
    override suspend fun fetchPopular(page: Int, perPage: Int): DataWrapperResponse = api.getPopularWallpaper(page, perPage)
}