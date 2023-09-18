package com.lucasmendes.wallapp.framework.di.usecasemolude

import com.lucasmendes.core.usecase.popularusecase.GetPopularUseCase
import com.lucasmendes.core.usecase.popularusecase.GetPopularUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindPopularUseCase(useCase: GetPopularUseCaseImpl): GetPopularUseCase
}