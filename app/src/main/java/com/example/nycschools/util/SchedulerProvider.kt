package com.example.nycschools.util

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * SchedulerProvider - Interface for Scheduler
 * */
interface SchedulerProvider {
    fun io(): Scheduler
    fun ui(): Scheduler
}

/**
 * AppSchedulerProvider - SchedulerProvider implementation for App
 * */
class AppSchedulerProvider : SchedulerProvider {
    override fun io(): Scheduler = Schedulers.io()
    override fun ui(): Scheduler = AndroidSchedulers.mainThread()
}

/**
 * TestSchedulerProvider - SchedulerProvider implementation for Test
 * */
class TestSchedulerProvider : SchedulerProvider {
    override fun io() = Schedulers.trampoline()
    override fun ui() = Schedulers.trampoline()
}
