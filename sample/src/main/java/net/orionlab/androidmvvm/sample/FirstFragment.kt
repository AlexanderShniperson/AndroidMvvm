package net.orionlab.androidmvvm.sample

import net.orionlab.androidmvvm.MvvmFragment
import net.orionlab.androidmvvm.sample.databinding.FirstFragmentBinding
import net.orionlab.androidmvvm.sample.viewModel.FirstViewModel

class FirstFragment : MvvmFragment<FirstFragmentBinding, FirstViewModel>() {
    override fun getScreenTitle(): String? {
        return context?.getString(R.string.app_name)
    }

    override fun onMvvmComponentInit() {
    }
}
