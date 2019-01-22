package com.visally.showme.ui.venuelist

import com.visally.showme.infrustructure.data.DataManager
import com.visally.showme.infrustructure.data.model.api.searchvenue.SearchVenueResponse
import com.visally.showme.infrustructure.utils.AppConstants
import com.visally.showme.infrustructure.utils.getDate
import com.visally.showme.infrustructure.utils.rx.TestSchedulerProvider
import io.reactivex.Single
import io.reactivex.schedulers.TestScheduler
import junit.framework.Assert.assertEquals
import org.junit.*

import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class VenueListViewModelTest {


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
        var testScheduler = TestSchedulerProvider(mTestScheduler)
        mVenueListViewModel = VenueListViewModel(mMockDataManager, testScheduler)
        mVenueListViewModel.setNavigator(mVenueListNavigator!!)

    }

    @After
    fun tearDown() {
        mVenueListNavigator = null
    }

    @Test
    fun retrieveDataTest() {

    }

    @Test
    fun getNearVenueTest() {
        val lat = "35.797834"
        val lng = "51.43404"
        val page = 1
        val date  = getDate()

        val location: String = "$lat,$lng"
        val searchVenueResponse = SearchVenueResponse()

        assertEquals(location, "35.797834,51.43404")

        `when`(mMockDataManager
                .getNearVenueByLocationFromApi(location, AppConstants.CLIET_ID,
                        AppConstants.CLIET_SECRET, date, AppConstants.PAGE_LIMIT, page * AppConstants.PAGE_LIMIT))
                .thenReturn(Single.just(searchVenueResponse))
        mTestScheduler.triggerActions()

    }
}