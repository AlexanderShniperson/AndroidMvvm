package net.orionlab.androidmvvm.sample.viewModel

import android.app.Application
import android.view.View
import net.orionlab.androidmvvm.MvvmActionLiveData
import net.orionlab.androidmvvm.MvvmAndroidViewModel
import net.orionlab.androidmvvm.sample.utils.DialogUtils

class ViewPagerThirdViewModel(app: Application) : MvvmAndroidViewModel(app) {
    val errorMessageObserver = MvvmActionLiveData<DialogUtils.DialogHandler>()

    fun onErrorClick(view: View) {
        errorMessageObserver.postValue(DialogUtils.DialogHandler("", "Some error thrown."))
    }
}
