package com.lucasmendes.wallapp.framework.di.repositorymodule

import com.lucasmendes.core.data.repository.PopularRemoteDataSrc
import com.lucasmendes.core.data.repository.PopularRepository
import com.lucasmendes.wallapp.framework.network.response.DataWrapperResponse
import com.lucasmendes.wallapp.framework.remote.PopularRemoteDataSourceImpl
import com.lucasmendes.wallapp.framework.repository.PopularRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface WallpapersRepositoryModule {

    @Binds
    fun bindPopularRepository(repository: PopularRepositoryImpl): PopularRepository

    @Binds
    fun bindPopularRemoteDataSource(dataSrc: PopularRemoteDataSourceImpl): PopularRemoteDataSrc<DataWrapperResponse>
}