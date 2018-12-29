package net.orionlab.androidmvvm.sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import net.orionlab.androidmvvm.MvvmFragment
import net.orionlab.androidmvvm.sample.navigation.Screens
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var navigatorHolder: NavigatorHolder
    @Inject
    lateinit var router: Router
    private val containerId = R.id.frame_container
    private val navigator = SupportAppNavigator(this, containerId)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.appComponent.inject(this)
    }

    override fun onStart() {
        super.onStart()
        router.newRootScreen(Screens.FirstScreen())
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        val fragment = supportFragmentManager.findFragmentById(containerId)
        if (fragment != null
            && fragment is MvvmFragment.OnBackPressedListener
            && fragment.onBackPressed()
        ) {
            return
        } else {
            router.exit()
        }
    }
}
