package net.orionlab.androidmvvm.sample.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import net.orionlab.androidmvvm.MvvmFragment

class ViewPagerAdapter(
    fragmentManager: FragmentManager,
    val fragments: List<MvvmFragment<*, *>>,
    val pageTitles: List<String>
) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return pageTitles[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }
}