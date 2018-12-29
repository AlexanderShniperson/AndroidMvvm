package net.orionlab.androidmvvm.sample.navigation

import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.Screen

class AppRouter : Router() {

    var onNewRootScreenListener: ((Screen) -> Unit)? = null

    override fun newRootScreen(screenKey: Screen) {
        super.newRootScreen(screenKey)
        onNewRootScreenListener?.invoke(screenKey)
    }

}