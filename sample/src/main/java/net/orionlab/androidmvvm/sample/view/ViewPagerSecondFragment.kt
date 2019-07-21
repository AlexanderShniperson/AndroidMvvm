package net.orionlab.androidmvvm.sample.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import net.orionlab.androidmvvm.MvvmFragment
import net.orionlab.androidmvvm.sample.databinding.ViewPagerSecondFragmentBinding
import net.orionlab.androidmvvm.sample.utils.DialogUtils
import net.orionlab.androidmvvm.sample.viewModel.ViewPagerSecondViewModel

class ViewPagerSecondFragment : MvvmFragment<ViewPagerSecondFragmentBinding, ViewPagerSecondViewModel>() {
    override fun onMvvmComponentInit(isRestored: Boolean) {
        viewModel?.infoMessageObserver?.observe(this, Observer {
            it?.let {
                DialogUtils.createInfoDialog(activity!!, it.message)
            }
        })
        viewModel?.questionMessageObserver?.observe(this, Observer {
            it?.let {
                DialogUtils.createQuestionDialog(activity!!, it.message, it.okTextId, it.okClickListener)
            }
        })
    }

    override fun getViewBindingInstance(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ViewPagerSecondFragmentBinding {
        return ViewPagerSecondFragmentBinding.inflate(inflater, container, false)
    }

    override fun getViewModelClass(): Class<ViewPagerSecondViewModel> {
        return ViewPagerSecondViewModel::class.java
    }

    override fun onPause() {
        viewModel?.infoMessageObserver?.removeObservers(this)
        viewModel?.questionMessageObserver?.removeObservers(this)
        super.onPause()
    }
}
