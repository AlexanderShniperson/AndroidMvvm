package net.orionlab.androidmvvm.sample.navigation

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import net.orionlab.androidmvvm.sample.view.FirstFragment
import net.orionlab.androidmvvm.sample.SecondActivity
import net.orionlab.androidmvvm.sample.view.SecondFragment
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

    class CommunicationScreen : SupportAppScreen() {
        override fun getActivityIntent(context: Context?): Intent {
            return Intent(context, SecondActivity::class.java)
        }
    }
}