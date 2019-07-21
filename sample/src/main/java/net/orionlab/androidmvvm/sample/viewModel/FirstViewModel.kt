package net.orionlab.androidmvvm.sample.viewModel

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import net.orionlab.androidmvvm.sample.App
import net.orionlab.androidmvvm.sample.navigation.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class FirstViewModel(app: Application) : AndroidViewModel(app) {
    @Inject
    lateinit var router: Router

    init {
        App.appComponent.inject(this)
    }

    fun onSecondClick(view: View) {
        router.navigateTo(Screens.SecondScreen())
    }

    fun onCommunicationClick(view: View) {
        router.navigateTo(Screens.CommunicationScreen())
    }
}
