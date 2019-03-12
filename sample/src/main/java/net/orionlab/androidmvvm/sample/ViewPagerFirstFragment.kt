package net.orionlab.androidmvvm.sample

import androidx.lifecycle.Observer
import net.orionlab.androidmvvm.MvvmFragment
import net.orionlab.androidmvvm.sample.databinding.ViewPagerFirstFragmentBinding
import net.orionlab.androidmvvm.sample.utils.DialogUtils
import net.orionlab.androidmvvm.sample.viewModel.ViewPagerFirstViewModel

class ViewPagerFirstFragment : MvvmFragment<ViewPagerFirstFragmentBinding, ViewPagerFirstViewModel>() {
    override fun onMvvmComponentInit() {
        viewModel?.infoMessageObserver?.observe(this, Observer {
            it?.let {
                DialogUtils.createInfoDialog(activity!!, it.message)
            }
        })
    }

    override fun onStop() {
        viewModel?.infoMessageObserver?.removeObservers(this)
        super.onStop()
    }
}
