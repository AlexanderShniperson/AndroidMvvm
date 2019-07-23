package net.orionlab.androidmvvm.sample.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import net.orionlab.androidmvvm.MvvmFragment
import net.orionlab.androidmvvm.sample.databinding.ViewPagerThirdFragmentBinding
import net.orionlab.androidmvvm.sample.utils.DialogUtils
import net.orionlab.androidmvvm.sample.viewModel.ViewPagerThirdViewModel

class ViewPagerThirdFragment : MvvmFragment<ViewPagerThirdFragmentBinding, ViewPagerThirdViewModel>() {
    override fun getViewBindingInstance(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ViewPagerThirdFragmentBinding {
        return ViewPagerThirdFragmentBinding.inflate(inflater, container, false)
    }

    override fun getViewModelClass(): Class<ViewPagerThirdViewModel> {
        return ViewPagerThirdViewModel::class.java
    }

    override fun onViewModelCreated(isViewRestored: Boolean) {
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
