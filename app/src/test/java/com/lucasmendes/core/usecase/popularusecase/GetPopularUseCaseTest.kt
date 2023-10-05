package com.lucasmendes.core.usecase.popularusecase

import MainCoroutineRule
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.lucasmendes.core.data.repository.PopularRepository
import com.lucasmendes.testing.model.WallpapersFactory
import com.lucasmendes.testing.pagingsource.PagingSourceFactory
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
class GetPopularUseCaseTest{

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Mock
    lateinit var repository: PopularRepository

    private lateinit var getPopularUseCase: GetPopularUseCase

    private val photos = WallpapersFactory().create(WallpapersFactory.Photo.PhotoDomainSuccess)

    private val mockPagingSource = PagingSourceFactory().create(listOf(photos))

    @Before
    fun setup(){
        getPopularUseCase = GetPopularUseCaseImpl(repository)
    }

    @Test
    fun `should validate flow paging data creation when invoke from use case is called`() = runTest {
        whenever(repository.fetchPopular(40)).thenReturn(mockPagingSource)

        val result = getPopularUseCase.invoke(GetPopularUseCase.GetPopularParams(PagingConfig(40)))

        verify(repository).fetchPopular(40)

        assertNotNull(result.first())
    }

}