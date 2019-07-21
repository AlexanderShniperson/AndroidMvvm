package net.orionlab.androidmvvm.sample.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.Observable
import net.orionlab.androidmvvm.MvvmFragment
import net.orionlab.androidmvvm.sample.CommunicationListener
import net.orionlab.androidmvvm.sample.viewModel.SecondCommunicationViewModel
import net.orionlab.androidmvvm.sample.databinding.FragmentSecondCommunicationBinding

class SecondCommunicationFragment : MvvmFragment<FragmentSecondCommunicationBinding, SecondCommunicationViewModel>(),
    CommunicationListener {
    override fun getViewBindingInstance(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSecondCommunicationBinding {
        return FragmentSecondCommunicationBinding.inflate(inflater, container, false)
    }

    override fun getViewModelClass(): Class<SecondCommunicationViewModel> {
        return SecondCommunicationViewModel::class.java
    }

    override fun onMvvmComponentInit(isRestored: Boolean) {
        viewModel?.secondField?.removeOnPropertyChangedCallback(propertyChangedCallback)
        viewModel?.secondField?.addOnPropertyChangedCallback(propertyChangedCallback)
    }

    private val propertyChangedCallback = object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
            if (activity is CommunicationListener) {
                viewModel?.secondField?.get()?.let {
                    (activity as CommunicationListener).onCommunication(it)
                }
            }
        }
    }

    override fun onCommunication(value: String) {
        viewModel?.secondField?.removeOnPropertyChangedCallback(propertyChangedCallback)
        viewModel?.secondField?.set(value)
        viewModel?.secondField?.addOnPropertyChangedCallback(propertyChangedCallback)
    }
}
