package net.orionlab.androidmvvm.sample.viewModel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel

class SecondCommunicationViewModel(app: Application) : AndroidViewModel(app) {
    val secondField = ObservableField<String>()

}