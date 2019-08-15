package net.orionlab.androidmvvm.sample.viewModel

import android.view.View
import androidx.lifecycle.ViewModel
import net.orionlab.androidmvvm.MvvmActionLiveData
import net.orionlab.androidmvvm.sample.utils.DialogUtils.DialogHandler

class ViewPagerFirstViewModel : ViewModel() {
    val infoMessageObserver = MvvmActionLiveData<DialogHandler>()

    fun onInfoClick(view: View) {
        infoMessageObserver.postValue(DialogHandler("", "Some information dialog handled."))
    }
}
