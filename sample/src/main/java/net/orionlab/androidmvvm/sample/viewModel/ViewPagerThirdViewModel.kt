package net.orionlab.androidmvvm.sample.viewModel

import android.view.View
import androidx.lifecycle.ViewModel
import net.orionlab.androidmvvm.MvvmActionLiveData
import net.orionlab.androidmvvm.sample.utils.DialogUtils

class ViewPagerThirdViewModel : ViewModel() {
    val errorMessageObserver = MvvmActionLiveData<DialogUtils.DialogHandler>()

    fun onErrorClick(view: View) {
        errorMessageObserver.postValue(DialogUtils.DialogHandler("", "Some error thrown."))
    }
}
