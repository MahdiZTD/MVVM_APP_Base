package com.visally.showme.infrustructure.data.local.db

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.visally.showme.infrustructure.data.local.db.dao.VenueDao
import com.visally.showme.infrustructure.data.model.db.VenueModel
import com.visally.showme.infrustructure.utils.AppConstants
import io.reactivex.schedulers.Schedulers
import org.junit.*
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnit
import org.mockito.MockitoAnnotations.initMocks
import timber.log.Timber
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit


@RunWith(AndroidJUnit4::class)
class AppDatabaseTest {

    @get:Rule
    var mockitoRule = MockitoJUnit.rule()!!


    private var venueDao: VenueDao? = null

    @Before
    fun setup() {
        initMocks(this)
        venueDao = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getTargetContext(), AppDatabase::class.java)
                .fallbackToDestructiveMigration().build().venueDao()
    }

    @After
    fun tearDown() {

    }

    @Test
    fun getAllVenueByLocationFromDbTest() {
        val lat: Float = 35.797565F
        val lng: Float = 51.433716F
        var venues: MutableList<VenueModel>? = null

        val venueList:MutableList<VenueModel> = mutableListOf(
            VenueModel("102", lat + (AppConstants.METER_DISTANCE / 2), lng + (AppConstants.METER_DISTANCE / 2),
                    "place_1", "crossStreet", "400",
                    "formattedAddress", "city", "category_1"),
            VenueModel("103", lat + (AppConstants.METER_DISTANCE / 2), lng - (AppConstants.METER_DISTANCE / 2),
                    "place_2", "crossStreet", "400",
                    "formattedAddress", "city", "category_1"),
            VenueModel("104", lat - (AppConstants.METER_DISTANCE / 2), lng + (AppConstants.METER_DISTANCE / 2),
                    "place_3", "crossStreet", "400",
                    "formattedAddress", "city", "category_1"),
            VenueModel("105", lat - (AppConstants.METER_DISTANCE / 2), lng - (AppConstants.METER_DISTANCE / 2),
                    "place_4", "crossStreet", "400",
                    "formattedAddress", "city", "category_1"),
            VenueModel("106", lat + (AppConstants.METER_DISTANCE * 2), lng + (AppConstants.METER_DISTANCE * 2),
                    "place_5", "crossStreet", "400",
                    "formattedAddress", "city", "category_1"),
            VenueModel("107", lat + (AppConstants.METER_DISTANCE * 2), lng - (AppConstants.METER_DISTANCE * 2),
                    "place_5", "crossStreet", "400",
                    "formattedAddress", "city", "category_1")

        )
        venueDao?.insertVenueList(venueList)

        venueDao?.queryByLocation(lat, lng)?.subscribeOn(Schedulers.io())
                ?.observeOn(Schedulers.io())
                ?.subscribe(
                        {
                            Assert.assertEquals(true,(it.size==4))
                            it.forEach {
                                Assert.assertEquals(true, (it.latitude!! < lat + AppConstants.METER_DISTANCE))
                                Assert.assertEquals(true, (it.latitude!! > lat - AppConstants.METER_DISTANCE))
                                Assert.assertEquals(true, (it.longitude!! < lng + AppConstants.METER_DISTANCE))
                                Assert.assertEquals(true, (it.longitude!! > lng - AppConstants.METER_DISTANCE))
                            }
                        },
                        {
                            it.printStackTrace()
                        }
                )

    }

    @Test
    fun insertVenues() {
        val venue = VenueModel("102", 35f, 36f,
                "place_1", "crossStreet", "400",
                "formattedAddress", "city", "category_1")
        venueDao?.insertVenue(venue)
        val venueTest = getValue(venueDao?.getVenueById(venue.placeId)!!)
        Assert.assertEquals(venue.name, venueTest.name)
    }

    @Throws(InterruptedException::class)
    fun <T> getValue(liveData: LiveData<T>): T {
        val data = arrayOfNulls<Any>(1)
        val latch = CountDownLatch(1)
        val observer = object : Observer<T> {
            override fun onChanged(t: T?) {
                data[0] = t
                latch.countDown()
                liveData.removeObserver(this)//To change body of created functions use File | Settings | File Templates.
            }

        }
        liveData.observeForever(observer)
        latch.await(2, TimeUnit.SECONDS)

        return data[0] as T
    }

}