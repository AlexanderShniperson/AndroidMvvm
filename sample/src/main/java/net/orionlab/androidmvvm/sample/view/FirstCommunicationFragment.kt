package net.orionlab.androidmvvm.sample.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.Observable
import net.orionlab.androidmvvm.MvvmFragment
import net.orionlab.androidmvvm.sample.CommunicationListener
import net.orionlab.androidmvvm.sample.viewModel.FirstCommunicationViewModel
import net.orionlab.androidmvvm.sample.databinding.FragmentFirstCommunicationBinding

class FirstCommunicationFragment : MvvmFragment<FragmentFirstCommunicationBinding, FirstCommunicationViewModel>(),
    CommunicationListener {
    override fun getViewBindingInstance(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFirstCommunicationBinding {
        return FragmentFirstCommunicationBinding.inflate(inflater, container, false)
    }

    override fun getViewModelClass(): Class<FirstCommunicationViewModel> {
        return FirstCommunicationViewModel::class.java
    }

    override fun onMvvmComponentInit(isRestored: Boolean) {
        viewModel?.firstField?.removeOnPropertyChangedCallback(propertyChangedCallback)
        viewModel?.firstField?.addOnPropertyChangedCallback(propertyChangedCallback)
    }

    private val propertyChangedCallback = object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
            if (activity is CommunicationListener) {
                viewModel?.firstField?.get()?.let {
                    (activity as CommunicationListener).onCommunication(it)
                }
            }
        }
    }

    override fun onCommunication(value: String) {
        viewModel?.firstField?.removeOnPropertyChangedCallback(propertyChangedCallback)
        viewModel?.firstField?.set(value)
        viewModel?.firstField?.addOnPropertyChangedCallback(propertyChangedCallback)
    }
}
