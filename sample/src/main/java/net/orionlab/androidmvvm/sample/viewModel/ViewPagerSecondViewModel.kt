package net.orionlab.androidmvvm.sample.viewModel

import android.app.Application
import android.content.DialogInterface
import android.view.View
import androidx.lifecycle.AndroidViewModel
import net.orionlab.androidmvvm.MvvmActionLiveData
import net.orionlab.androidmvvm.sample.utils.DialogUtils

class ViewPagerSecondViewModel(app: Application) : AndroidViewModel(app) {
    val infoMessageObserver = MvvmActionLiveData<DialogUtils.DialogHandler>()
    val questionMessageObserver = MvvmActionLiveData<DialogUtils.DialogHandler>()

    fun onQuestionClick(view: View) {
        questionMessageObserver.postValue(
            DialogUtils.DialogHandler(
                "",
                "Do you want to handle click OK button?",
                android.R.string.ok,
                DialogInterface.OnClickListener { dialogInterface, i ->
                    this.onQuestionDialogOkHandled()
                })
        )
    }

    fun onQuestionDialogOkHandled() {
        infoMessageObserver.postValue(DialogUtils.DialogHandler("", "Question dialog OK handled."))
    }
}
