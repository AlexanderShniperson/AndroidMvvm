package net.orionlab.androidmvvm.sample

import androidx.lifecycle.Observer
import net.orionlab.androidmvvm.MvvmFragment
import net.orionlab.androidmvvm.sample.databinding.ViewPagerSecondFragmentBinding
import net.orionlab.androidmvvm.sample.utils.DialogUtils
import net.orionlab.androidmvvm.sample.viewModel.ViewPagerSecondViewModel

class ViewPagerSecondFragment : MvvmFragment<ViewPagerSecondFragmentBinding, ViewPagerSecondViewModel>() {
    override fun onMvvmComponentInit() {
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

    override fun onStop() {
        viewModel?.infoMessageObserver?.removeObservers(this)
        viewModel?.questionMessageObserver?.removeObservers(this)
        super.onStop()
    }
}
