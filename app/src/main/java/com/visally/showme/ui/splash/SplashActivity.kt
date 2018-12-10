package com.visally.showme.ui.splash

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.visally.showme.R
import com.visally.showme.databinding.ActivitySplashBinding
import com.visally.showme.ui.venuelist.VenueListActivity
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class SplashActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        var s = Observable.timer(3,TimeUnit.SECONDS,Schedulers.io())
                .subscribe {
                    startActivity(Intent(applicationContext,VenueListActivity::class.java))
                }
    }
}
