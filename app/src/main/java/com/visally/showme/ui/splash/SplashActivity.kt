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
import android.R.raw
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget
import io.reactivex.disposables.CompositeDisposable
import com.visally.showme.R.id.imageView




class SplashActivity : AppCompatActivity() {
    private val compositeDisposable = CompositeDisposable()
    lateinit var binding : ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        Glide.with(this)
                .load(R.raw.animation)
                .asGif()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(binding.imgAnimation)

        compositeDisposable.add(Observable.timer(3,TimeUnit.SECONDS,Schedulers.io())
                .subscribe {
                    startActivity(Intent(this,VenueListActivity::class.java))
                    this.finish()
                }
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }

}
