package net.orionlab.androidmvvm.sample.viewModel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class FirstCommunicationViewModel : ViewModel() {
    val firstField = ObservableField<String>()

}