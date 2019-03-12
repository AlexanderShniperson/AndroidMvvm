package net.orionlab.androidmvvm.sample.navigation

import androidx.fragment.app.Fragment
import net.orionlab.androidmvvm.sample.FirstFragment
import net.orionlab.androidmvvm.sample.SecondFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {
    class FirstScreen : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return FirstFragment()
        }
    }

    class SecondScreen : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return SecondFragment()
        }
    }
}