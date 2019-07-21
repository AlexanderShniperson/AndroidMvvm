package net.orionlab.androidmvvm.sample.viewModel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel

class FirstCommunicationViewModel(app: Application) : AndroidViewModel(app) {
    val firstField = ObservableField<String>()

}