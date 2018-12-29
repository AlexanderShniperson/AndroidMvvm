package net.orionlab.androidmvvm.sample.viewModel

import android.app.Application
import android.view.View
import net.orionlab.androidmvvm.MvvmActionLiveData
import net.orionlab.androidmvvm.MvvmAndroidViewModel
import net.orionlab.androidmvvm.sample.utils.DialogUtils.DialogHandler

class ViewPagerFirstViewModel(app: Application) : MvvmAndroidViewModel(app) {
    val infoMessageObserver = MvvmActionLiveData<DialogHandler>()

    fun onInfoClick(view: View) {
        infoMessageObserver.postValue(DialogHandler("", "Some information dialog handled."))
    }
}
