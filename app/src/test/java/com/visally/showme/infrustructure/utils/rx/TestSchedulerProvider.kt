package com.visally.showme.infrustructure.utils.rx

import io.reactivex.Scheduler
import io.reactivex.schedulers.TestScheduler
import org.junit.Test

import org.junit.Assert.*

class TestSchedulerProvider constructor(var mTestScheduler:TestScheduler) :SchedulersProvider {
    override fun computation(): Scheduler {
        return mTestScheduler
    }

    override fun io(): Scheduler {
        return mTestScheduler
    }

    override fun ui(): Scheduler {
        return mTestScheduler
    }

}