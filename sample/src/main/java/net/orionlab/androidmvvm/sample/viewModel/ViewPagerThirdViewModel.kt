package net.orionlab.androidmvvm.sample.viewModel

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import net.orionlab.androidmvvm.MvvmActionLiveData
import net.orionlab.androidmvvm.sample.utils.DialogUtils

class ViewPagerThirdViewModel(app: Application) : AndroidViewModel(app) {
    val errorMessageObserver = MvvmActionLiveData<DialogUtils.DialogHandler>()

    fun onErrorClick(view: View) {
        errorMessageObserver.postValue(DialogUtils.DialogHandler("", "Some error thrown."))
    }
}
