package net.orionlab.androidmvvm.sample

import net.orionlab.androidmvvm.MvvmFragment
import net.orionlab.androidmvvm.sample.databinding.SecondFragmentBinding
import net.orionlab.androidmvvm.sample.viewModel.SecondViewModel

class SecondFragment : MvvmFragment<SecondFragmentBinding, SecondViewModel>(), MvvmFragment.OnBackPressedListener {
    override fun getScreenTitle(): String? {
        return context?.getString(R.string.title_second_screen)
    }

    override fun onMvvmComponentInit() {
        viewModel?.configureUI(childFragmentManager, viewBinding!!.tabLayout, viewBinding!!.viewPager)
    }

    override fun onStop() {
        super.onStop()
        // we need this to destroy adapter and also created fragments
        viewBinding?.viewPager?.adapter = null
    }
}
