package com.visally.showme.ui.venuelist

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import com.visally.showme.infrustructure.data.DataManager
import com.visally.showme.infrustructure.data.model.api.searchvenue.SearchVenueResponse
import com.visally.showme.infrustructure.data.model.api.venuedetail.VenueDetailResponse
import com.visally.showme.infrustructure.data.model.db.VenueModel
import com.visally.showme.infrustructure.utils.AppConstants
import com.visally.showme.infrustructure.utils.getDate
import com.visally.showme.infrustructure.utils.rx.TestSchedulerProvider
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.schedulers.TestScheduler
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.*

import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class VenueListViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    var mVenueListNavigator: VenueListNavigator? = null

    @Mock
    lateinit var mMockDataManager: DataManager


    private lateinit var mVenueListViewModel: VenueListViewModel
    private lateinit var mTestScheduler: TestScheduler

    companion object {
        @BeforeClass
        @Throws(Exception::class)
        @JvmStatic
        fun onlyOnce() {
        }
    }

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mTestScheduler = TestScheduler()
        val testScheduler = TestSchedulerProvider(mTestScheduler)
        mVenueListViewModel = VenueListViewModel(mMockDataManager, testScheduler)
        mVenueListViewModel.setNavigator(mVenueListNavigator!!)

    }

    @After
    fun tearDown() {
        mVenueListNavigator = null
    }

    @Test
    fun getNearVenueTest_successResponse() {
        val lat = "35.797834"
        val lng = "51.43404"
        val page = 1
        val date  = getDate()

        val location = "$lat,$lng"

        assertEquals(location, "35.797834,51.43404")


        Mockito.`when`(mMockDataManager
                .getNearVenueByLocationFromApi(location, AppConstants.CLIET_ID,
                        AppConstants.CLIET_SECRET, date, AppConstants.PAGE_LIMIT, page * AppConstants.PAGE_LIMIT))
                .thenReturn(Single.just(SearchVenueResponse()))

        val observer = mock(Observer::class.java) as Observer<MutableList<VenueModel>>
        mVenueListViewModel.mVenueModels.observeForever(observer)

        val spiedViewModel = com.nhaarman.mockitokotlin2.spy(mVenueListViewModel)
        spiedViewModel.dataManager.getNearVenueByLocationFromApi(location, AppConstants.CLIET_ID,
                AppConstants.CLIET_SECRET, date, AppConstants.PAGE_LIMIT, page * AppConstants.PAGE_LIMIT)

        assertNotNull(mVenueListViewModel.mVenueModels)
        mTestScheduler.triggerActions()

    }
}