package net.orionlab.androidmvvm.sample.viewModel

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import net.orionlab.androidmvvm.MvvmActionLiveData
import net.orionlab.androidmvvm.sample.utils.DialogUtils.DialogHandler

class ViewPagerFirstViewModel(app: Application) : AndroidViewModel(app) {
    val infoMessageObserver = MvvmActionLiveData<DialogHandler>()

    fun onInfoClick(view: View) {
        infoMessageObserver.postValue(DialogHandler("", "Some information dialog handled."))
    }
}
