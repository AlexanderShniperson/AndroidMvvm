package net.orionlab.androidmvvm

import android.os.Bundle

class RestorableParam(
    val field: String,
    val storeFunc: () -> MvvmBaseDataModel<*>?
) {
    fun getParcelable(state: Bundle?): MvvmBaseDataModel<Any>? {
        return state?.getParcelable<MvvmBaseDataModel<Any>>(field)
    }

    @Suppress("UNCHECKED_CAST")
    fun restoreParam(state: Bundle?) {
        getParcelable(state)?.let {
            (storeFunc.invoke() as MvvmBaseDataModel<Any>?)?.fromModel(it)
        }
    }
}