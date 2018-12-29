package net.orionlab.androidmvvm.sample.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import net.orionlab.androidmvvm.MvvmFragment

class ViewPagerAdapter(
    fragmentManager: FragmentManager,
    val fragments: List<MvvmFragment<*, *>>,
    val pageTitles: List<String>
) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment? {
        return fragments[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return pageTitles[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }
}