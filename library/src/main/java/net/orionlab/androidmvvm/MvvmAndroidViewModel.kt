package net.orionlab.androidmvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel

open class MvvmAndroidViewModel(app: Application) : AndroidViewModel(app) {
    open fun onDestroy() {
    }
}