package net.orionlab.androidmvvm.sample.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import net.orionlab.androidmvvm.MvvmFragment
import net.orionlab.androidmvvm.sample.databinding.ViewPagerFirstFragmentBinding
import net.orionlab.androidmvvm.sample.utils.DialogUtils
import net.orionlab.androidmvvm.sample.viewModel.ViewPagerFirstViewModel

class ViewPagerFirstFragment : MvvmFragment<ViewPagerFirstFragmentBinding, ViewPagerFirstViewModel>() {
    override fun getViewBindingInstance(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ViewPagerFirstFragmentBinding {
        return ViewPagerFirstFragmentBinding.inflate(inflater, container, false)
    }

    override fun getViewModelClass(): Class<ViewPagerFirstViewModel> {
        return ViewPagerFirstViewModel::class.java
    }

    override fun onMvvmComponentInit(isRestored: Boolean) {
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
