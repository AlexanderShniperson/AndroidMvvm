package net.orionlab.androidmvvm.sample.viewModel

import android.app.Application
import android.view.View
import net.orionlab.androidmvvm.MvvmAndroidViewModel
import net.orionlab.androidmvvm.sample.App
import net.orionlab.androidmvvm.sample.navigation.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class FirstViewModel(app: Application) : MvvmAndroidViewModel(app) {
    @Inject
    lateinit var router: Router

    init {
        App.appComponent.inject(this)
    }

    fun onButtonClick(view: View) {
          router.navigateTo(Screens.SecondScreen())
    }
}
