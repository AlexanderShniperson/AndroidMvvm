package net.orionlab.androidmvvm

import android.content.Context
import android.os.Parcelable

interface MvvmBaseDataModel<T> : Parcelable {
    fun isValid(context: Context): Boolean
    fun validationErrors(context: Context): List<String>
    fun fromModel(model: T)
}
