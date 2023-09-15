package com.lucasmendes.core.usecase.popularusecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.lucasmendes.core.data.repository.PopularRepository
import com.lucasmendes.core.domain.model.PhotoDomain
import com.lucasmendes.core.usecase.base.PagingUseCase
import kotlinx.coroutines.flow.Flow

interface GetPopularUseCase{
    operator fun invoke(params: GetPopularParams): Flow<PagingData<PhotoDomain>>
    data class GetPopularParams(val pagingConfig: PagingConfig)
}
class GetPopularUseCaseImpl(
    private val repository: PopularRepository
): PagingUseCase<GetPopularUseCase.GetPopularParams, PhotoDomain>(), GetPopularUseCase {
    override fun createFlowObservable(params: GetPopularUseCase.GetPopularParams): Flow<PagingData<PhotoDomain>> {
        val pagingSource = repository.fetchPopular(pages = params.pagingConfig.pageSize)
        return Pager(config = params.pagingConfig){
            pagingSource
        }.flow
    }
}