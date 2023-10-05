package com.lucasmendes.wallapp.framework.remote

import com.lucasmendes.core.data.repository.PopularRemoteDataSrc
import com.lucasmendes.wallapp.framework.network.api.WallpapersApi
import com.lucasmendes.wallapp.framework.network.response.DataWrapperResponse
import javax.inject.Inject

class PopularRemoteDataSourceImpl @Inject constructor(
    private val api: WallpapersApi
): PopularRemoteDataSrc<DataWrapperResponse> {
    override suspend fun fetchPopular(page: Int, perPage: Int): DataWrapperResponse = api.getPopularWallpaper(page, perPage)
}