package com.lucasmendes.wallapp.ui.fragment.popular.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.lucasmendes.core.domain.model.PhotoDomain
import com.lucasmendes.core.usecase.popularusecase.GetPopularUseCase
import kotlinx.coroutines.flow.Flow
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PopularViewModel @Inject constructor(
    private val popularUseCase: GetPopularUseCase
) : ViewModel() {

    fun popularWallpapes(): Flow<PagingData<PhotoDomain>> {
        return popularUseCase.invoke(GetPopularUseCase.GetPopularParams(getPagingConfig()))
            .cachedIn(viewModelScope)
    }

    private fun getPagingConfig() = PagingConfig(pageSize = 40)
}