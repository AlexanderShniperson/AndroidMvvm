package net.orionlab.androidmvvm.sample.view

import android.view.LayoutInflater
import android.view.ViewGroup
import net.orionlab.androidmvvm.MvvmFragment
import net.orionlab.androidmvvm.sample.R
import net.orionlab.androidmvvm.sample.databinding.FirstFragmentBinding
import net.orionlab.androidmvvm.sample.viewModel.FirstViewModel

class FirstFragment : MvvmFragment<FirstFragmentBinding, FirstViewModel>() {
    override fun getScreenTitle(): String? {
        return context?.getString(R.string.app_name)
    }

    override fun getViewBindingInstance(inflater: LayoutInflater, container: ViewGroup?): FirstFragmentBinding {
        return FirstFragmentBinding.inflate(inflater, container, false)
    }

    override fun getViewModelClass(): Class<FirstViewModel> {
        return FirstViewModel::class.java
    }

    override fun onMvvmComponentInit(isRestored: Boolean) {
    }
}
