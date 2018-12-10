package com.visally.showme.infrustructure.utils.rx

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

interface SchedulersProvider {

    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler
}