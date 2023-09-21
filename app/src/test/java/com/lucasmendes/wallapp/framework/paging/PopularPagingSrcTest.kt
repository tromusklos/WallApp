package com.lucasmendes.wallapp.framework.paging

import MainCoroutineRule
import androidx.paging.PagingSource
import com.lucasmendes.core.data.repository.PopularRemoteDataSrc
import com.lucasmendes.core.domain.model.PhotoDomain
import com.lucasmendes.testing.model.WallpapersFactory
import com.lucasmendes.wallapp.factory.DataWrapperResponseFactory
import com.lucasmendes.wallapp.framework.network.response.DataWrapperResponse
import com.lucasmendes.wallapp.framework.network.response.Photo
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Runnable
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.lang.RuntimeException


@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class PopularPagingSrcTest{
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Mock
    lateinit var remoteDataSrc: PopularRemoteDataSrc<DataWrapperResponse>

    private lateinit var pagingSrc: PopularPagingSrc

    private val photos = WallpapersFactory().create(WallpapersFactory.Photo.PhotoDomainSuccess)

    private val dataWrapperResponseFactory = DataWrapperResponseFactory()

    @Before
    fun setup(){
        pagingSrc = PopularPagingSrc(remoteDataSrc, 40)
    }

    @Test
    fun `should return a success load result when load is called`() = runTest {
        whenever(remoteDataSrc.fetchPopular(any(), any())).thenReturn(dataWrapperResponseFactory.create())

        val result = pagingSrc.load(
            PagingSource.LoadParams.Refresh(
                key = null,
                loadSize = 2,
                placeholdersEnabled = false
            )
        )

        val expected = listOf(photos, photos)

        assertEquals(
            PagingSource.LoadResult.Page(data = expected, prevKey = null, nextKey = 2),
            result
        )
    }

    @Test
    fun `should return error load result when load is called`() = runTest {
        val exception = RuntimeException()

        whenever(remoteDataSrc.fetchPopular(any(), any())).thenThrow((exception))

        val result = pagingSrc.load(
            PagingSource.LoadParams.Refresh(
                key = null,
                loadSize = 2,
                placeholdersEnabled = false
            )
        )
        assertEquals(
            PagingSource.LoadResult.Error<Int, PhotoDomain>(exception),
            result
        )
    }
}