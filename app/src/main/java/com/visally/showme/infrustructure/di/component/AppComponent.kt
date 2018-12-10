package com.visally.showme.infrustructure.di.component

import android.app.Application
import com.visally.showme.ShowMeApp
import com.visally.showme.infrustructure.di.builder.ActivityBuilder
import com.visally.showme.infrustructure.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class , AppModule::class, ActivityBuilder::class))
interface AppComponent {
    fun inject(app: ShowMeApp)

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application:Application):Builder
        fun build():AppComponent
    }
}