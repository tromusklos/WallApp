package com.lucasmendes.wallapp.ui.fragment.popular.viewmodel

import MainCoroutineRule
import androidx.paging.PagingData
import com.lucasmendes.core.usecase.popularusecase.GetPopularUseCase
import com.lucasmendes.testing.model.WallpapersFactory
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
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
class PopularViewModelTest{

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Mock
    lateinit var popularUseCase: GetPopularUseCase
    lateinit var popularViewModel: PopularViewModel

    private val wallpapersFactory = WallpapersFactory()

    @Before
    fun setup(){
        popularViewModel = PopularViewModel(popularUseCase)
    }

    @Test
    fun `Should validate pagination data`() = runTest{
    // Arrange
        whenever(popularUseCase.invoke(any())).thenReturn(flowOf(getPagingDataMock))
        //Act
        val result = popularViewModel.popularWallpapes()

        //Assert
        assertNotNull(result.first())
    }
    @Test(expected = RuntimeException::class)
    fun `Should return an empty PagingData When an error occurred`() = runTest{
        whenever(popularUseCase(any())).thenThrow(RuntimeException())

        popularViewModel.popularWallpapes()

    }

    private val getPagingDataMock = PagingData.from(
        listOf(
            wallpapersFactory.create(WallpapersFactory.Photo.PhotoDomainSuccess),
            wallpapersFactory.create(WallpapersFactory.Photo.PhotoDomainSuccess)

        )
    )
}