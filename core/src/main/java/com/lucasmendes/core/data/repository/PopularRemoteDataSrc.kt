package com.lucasmendes.core.data.repository

interface PopularRemoteDataSrc<T> {
    suspend fun fetchPopular(page: Int, perPage: Int): T
}