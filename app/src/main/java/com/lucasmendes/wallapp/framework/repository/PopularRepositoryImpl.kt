package com.lucasmendes.wallapp.framework.repository

import androidx.paging.PagingSource
import com.lucasmendes.core.data.repository.PopularRemoteDataSrc
import com.lucasmendes.core.data.repository.PopularRepository
import com.lucasmendes.core.domain.model.PhotoDomain
import com.lucasmendes.wallapp.framework.network.response.DataWrapperResponse
import com.lucasmendes.wallapp.framework.paging.PopularPagingSrc

class PopularRepositoryImpl(
    private val remoteDataSrc: PopularRemoteDataSrc<DataWrapperResponse>
): PopularRepository {
    override fun fetchPopular(pages: Int): PagingSource<Int, PhotoDomain> {
        return PopularPagingSrc(remoteDataSrc, pages)
    }
}