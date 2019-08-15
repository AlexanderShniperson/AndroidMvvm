package net.orionlab.androidmvvm.sample.viewModel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class SecondCommunicationViewModel : ViewModel() {
    val secondField = ObservableField<String>()

}