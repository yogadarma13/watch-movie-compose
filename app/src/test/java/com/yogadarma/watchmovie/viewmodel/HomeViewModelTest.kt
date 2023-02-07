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
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    private val dummyMovieList = DummyData().getDummyMovieList()
    private val expectedErrorMessage = "Error Response"

    @Mock
    lateinit var mockUseCase: GetPopularMovieUseCase

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
                assertTrue(it is UiState.Success)
                assertEquals(UiState.Success(dummyMovieList), it)
                assertEquals(dummyMovieList, (it as UiState.Success).data)
            }
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun testGetPopularMovie_returnErrorMessage() = runTest {
        val errorDummyFlow =
            flow<Resource<List<Movie>>> { emit(Resource.Error(expectedErrorMessage)) }

        `when`(mockUseCase.invoke()).thenReturn(errorDummyFlow)

        homeViewModel.getPopularMovie()

        homeViewModel.uiState.test {
            awaitItem().let {
                assertTrue(it is UiState.Error)
                assertEquals(UiState.Error(expectedErrorMessage), it)
                assertEquals(expectedErrorMessage, (it as UiState.Error).errorMessage)
            }
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun testSearchMovie_returnMovie2() = runTest {
        val dummyFlow = flow<Resource<List<Movie>>> { emit(Resource.Success(dummyMovieList)) }

        `when`(mockUseCase.invoke()).thenReturn(dummyFlow)

        homeViewModel.getPopularMovie()
        homeViewModel.searchMovie("Movie 2")

        homeViewModel.uiState.test {
            awaitItem().let {
                assertTrue(it is UiState.Success)
                assertEquals(UiState.Success(listOf(dummyMovieList[1])), it)
                assertEquals(dummyMovieList[1], (it as UiState.Success).data[0])
            }
            cancelAndIgnoreRemainingEvents()
        }
    }
}