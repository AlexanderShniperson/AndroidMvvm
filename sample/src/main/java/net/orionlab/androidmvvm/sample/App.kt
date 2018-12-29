package net.orionlab.androidmvvm.sample

import android.app.Application
import net.orionlab.androidmvvm.sample.di.AppComponent

class App : Application() {
    companion object {
        @JvmStatic
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        appComponent = AppComponent.Initializer.init(this)
    }
}