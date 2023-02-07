package com.yogadarma.watchmovie.viewmodel

import app.cash.turbine.test
import com.yogadarma.core.data.Resource
import com.yogadarma.core.domain.model.Movie
import com.yogadarma.core.domain.usecases.GetPopularMovieUseCase
import com.yogadarma.watchmovie.common.UiState
import com.yogadarma.watchmovie.ui.screen.home.HomeViewModel
import com.yogadarma.watchmovie.utils.Dispatcher
import com.yogadarma.watchmovie.utils.DummyData
import com.yogadarma.watchmovie.utils.TestDispatcherProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    @Mock
    lateinit var mockUseCase: GetPopularMovieUseCase

    private val dummyMovieList = DummyData().getDummyMovieList()

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var dispatcher: Dispatcher

    @Before
    fun setup() {
        dispatcher = TestDispatcherProvider()
        homeViewModel = HomeViewModel(mockUseCase, dispatcher)
    }

    @Test
    fun testGetPopularMovie_returnMovieList() = runTest {

        val dummyFlow = flow<Resource<List<Movie>>> { emit(Resource.Success(dummyMovieList)) }

        `when`(mockUseCase.invoke()).thenReturn(dummyFlow)

        homeViewModel.getPopularMovie()

        homeViewModel.uiState.test {
            awaitItem().let {
                assertEquals(UiState.Success(dummyMovieList), it)
                assertEquals((it as UiState.Success).data, dummyMovieList)
            }
            cancelAndIgnoreRemainingEvents()
        }
    }
}