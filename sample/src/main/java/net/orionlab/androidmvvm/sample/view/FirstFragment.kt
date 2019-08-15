package net.orionlab.androidmvvm.sample.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import net.orionlab.androidmvvm.MvvmFragment
import net.orionlab.androidmvvm.sample.R
import net.orionlab.androidmvvm.sample.databinding.FirstFragmentBinding
import net.orionlab.androidmvvm.sample.viewModel.FirstViewModel

class FirstFragment : MvvmFragment<FirstFragmentBinding, FirstViewModel>() {
    override fun getActionBarTitle(): String? {
        return context?.getString(R.string.app_name)
    }

    /**
     * Method implemented because we need Application instance at ViewModel
     */
    override fun getViewModelFactory(): ViewModelProvider.Factory? {
        return ViewModelProvider.AndroidViewModelFactory.getInstance(activity!!.application)
    }

    override fun getViewBindingInstance(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FirstFragmentBinding {
        return FirstFragmentBinding.inflate(inflater, container, false)
    }

    override fun getViewModelClass(): Class<FirstViewModel> {
        return FirstViewModel::class.java
    }

    override fun onViewModelCreated(isViewRestored: Boolean) {
    }
}
