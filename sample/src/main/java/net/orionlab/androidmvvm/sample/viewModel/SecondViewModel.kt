package net.orionlab.androidmvvm.sample.viewModel

import android.app.Application
import android.support.design.widget.TabLayout
import android.support.v4.app.FragmentManager
import android.support.v4.view.ViewPager
import net.orionlab.androidmvvm.MvvmAndroidViewModel
import net.orionlab.androidmvvm.sample.R
import net.orionlab.androidmvvm.sample.ViewPagerFirstFragment
import net.orionlab.androidmvvm.sample.ViewPagerSecondFragment
import net.orionlab.androidmvvm.sample.ViewPagerThirdFragment
import net.orionlab.androidmvvm.sample.adapters.ViewPagerAdapter

class SecondViewModel(app: Application) : MvvmAndroidViewModel(app) {

    fun configureUI(fm: FragmentManager, tabLayout: TabLayout, viewPager: ViewPager) {
        viewPager.offscreenPageLimit = 1
        val fragments = arrayListOf(
            ViewPagerFirstFragment(),
            ViewPagerSecondFragment(),
            ViewPagerThirdFragment()
        )
        val appContext = getApplication<Application>()
        val tabTitles = arrayListOf(
            appContext.getString(R.string.tab_first_title),
            appContext.getString(R.string.tab_second_title),
            appContext.getString(R.string.tab_third_title)
        )
        viewPager.adapter = ViewPagerAdapter(fm, fragments, tabTitles)
        tabLayout.setupWithViewPager(viewPager)
    }

}
