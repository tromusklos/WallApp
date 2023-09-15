package com.lucasmendes.core.data.repository

import androidx.paging.PagingSource
import com.lucasmendes.core.domain.model.PhotoDomain

interface PopularRepository {
    fun fetchPopular(pages: Int): PagingSource<Int, PhotoDomain>
}