package net.orionlab.androidmvvm.sample.utils

import android.content.DialogInterface
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentActivity
import net.orionlab.androidmvvm.sample.R

class DialogUtils {
    data class DialogHandler(
        val title: String,
        val message: String,
        @StringRes val okTextId: Int? = null,
        val okClickListener: DialogInterface.OnClickListener? = null
    )

    companion object {
        @JvmStatic
        fun createInfoDialog(activity: FragmentActivity, message: String) {
            val dialog = AlertDialog.Builder(activity)
            dialog.setIcon(R.drawable.ic_info_black_24dp)
            dialog.setCancelable(false)
            dialog.setTitle("Info")
            dialog.setMessage(message)
            dialog.setPositiveButton(android.R.string.ok, null)
            dialog.show()
        }

        @JvmStatic
        fun createQuestionDialog(
            activity: FragmentActivity,
            message: String,
            @StringRes okTextId: Int?,
            okClickListener: DialogInterface.OnClickListener?
        ) {
            val dialog = AlertDialog.Builder(activity)
            dialog.setIcon(R.drawable.ic_question_black_24dp)
            dialog.setCancelable(false)
            dialog.setTitle("Question")
            dialog.setMessage(message)
            dialog.setNegativeButton(android.R.string.cancel, null)
            dialog.setPositiveButton(okTextId ?: android.R.string.ok, okClickListener)
            dialog.show()
        }

        @JvmStatic
        fun createErrorDialog(activity: FragmentActivity, message: String) {
            val dialog = AlertDialog.Builder(activity)
            dialog.setIcon(R.drawable.ic_error_black_24dp)
            dialog.setCancelable(false)
            dialog.setTitle("Error")
            dialog.setMessage(message)
            dialog.setPositiveButton(android.R.string.ok, null)
            dialog.show()
        }
    }
}