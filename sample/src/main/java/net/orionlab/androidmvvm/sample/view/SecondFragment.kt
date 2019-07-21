package net.orionlab.androidmvvm.sample.view

import android.view.LayoutInflater
import android.view.ViewGroup
import net.orionlab.androidmvvm.MvvmFragment
import net.orionlab.androidmvvm.sample.R
import net.orionlab.androidmvvm.sample.adapters.ViewPagerAdapter
import net.orionlab.androidmvvm.sample.databinding.SecondFragmentBinding
import net.orionlab.androidmvvm.sample.viewModel.SecondViewModel

class SecondFragment : MvvmFragment<SecondFragmentBinding, SecondViewModel>() {
    override fun getScreenTitle(): String? {
        return context?.getString(R.string.title_second_screen)
    }

    override fun getViewBindingInstance(inflater: LayoutInflater, container: ViewGroup?): SecondFragmentBinding {
        return SecondFragmentBinding.inflate(inflater, container, false)
    }

    override fun getViewModelClass(): Class<SecondViewModel> {
        return SecondViewModel::class.java
    }

    override fun onMvvmComponentInit(isRestored: Boolean) {
        viewBinding?.let { vb ->
            vb.viewPager.offscreenPageLimit = 1
            val fragments = arrayListOf(
                ViewPagerFirstFragment(),
                ViewPagerSecondFragment(),
                ViewPagerThirdFragment()
            )
            val tabTitles = arrayListOf(
                context!!.getString(R.string.tab_first_title),
                context!!.getString(R.string.tab_second_title),
                context!!.getString(R.string.tab_third_title)
            )
            vb.viewPager.adapter = ViewPagerAdapter(childFragmentManager, fragments, tabTitles)
            vb.tabLayout.setupWithViewPager(vb.viewPager)
        }
    }

    override fun onStop() {
        super.onStop()
        // we need this to destroy adapter and also created fragments
        viewBinding?.viewPager?.adapter = null
    }
}
