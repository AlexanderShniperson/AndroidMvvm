package net.orionlab.androidmvvm.sample

import android.arch.lifecycle.Observer
import net.orionlab.androidmvvm.MvvmFragment
import net.orionlab.androidmvvm.sample.databinding.ViewPagerThirdFragmentBinding
import net.orionlab.androidmvvm.sample.utils.DialogUtils
import net.orionlab.androidmvvm.sample.viewModel.ViewPagerThirdViewModel

class ViewPagerThirdFragment : MvvmFragment<ViewPagerThirdFragmentBinding, ViewPagerThirdViewModel>() {
    override fun onMvvmComponentInit() {
        viewModel?.errorMessageObserver?.observe(this, Observer {
            it?.let {
                DialogUtils.createErrorDialog(activity!!, it.message)
            }
        })
    }

    override fun onStop() {
        viewModel?.errorMessageObserver?.removeObservers(this)
        super.onStop()
    }
}
