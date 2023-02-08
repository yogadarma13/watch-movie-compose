package com.yogadarma.watchmovie.viewmodel

import app.cash.turbine.test
import com.yogadarma.core.domain.usecases.GetFavoriteUseCase
import com.yogadarma.watchmovie.common.UiState
import com.yogadarma.watchmovie.ui.screen.favorite.FavoriteViewModel
import com.yogadarma.watchmovie.utils.Dispatcher
import com.yogadarma.watchmovie.utils.DummyData
import com.yogadarma.watchmovie.utils.TestDispatcherProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest {

    private val dummyMovieList = DummyData.getDummyMovieList()

    @Mock
    lateinit var mockUseCase: GetFavoriteUseCase

    private lateinit var favoriteViewModel: FavoriteViewModel
    private lateinit var dispatcher: Dispatcher

    @Before
    fun setup() {
        dispatcher = TestDispatcherProvider()
        favoriteViewModel = FavoriteViewModel(mockUseCase, dispatcher)
    }

    @Test
    fun testGetFavoriteMovie_returnMovieList() = runTest {
        val dummyFlow = flow { emit(dummyMovieList) }

        Mockito.`when`(mockUseCase.invoke()).thenReturn(dummyFlow)

        favoriteViewModel.getAllFavoriteMovie()

        favoriteViewModel.uiState.test {
            awaitItem().let {
                Assert.assertTrue(it is UiState.Success)
                Assert.assertEquals(UiState.Success(dummyMovieList), it)
                Assert.assertEquals(dummyMovieList, (it as UiState.Success).data)
            }
            cancelAndIgnoreRemainingEvents()
        }
    }
}