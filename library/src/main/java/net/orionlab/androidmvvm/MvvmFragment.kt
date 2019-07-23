package net.orionlab.androidmvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

/**
 * Base Fragment that should be extended when using this library
 */
abstract class MvvmFragment<A : ViewDataBinding, B : ViewModel> : Fragment() {
    var viewBinding: A? = null
    var viewModel: B? = null

    /**
     * Store flag that View has been restored
     */
    private var isRestoredState = false

    /**
     * Indicates that ActionBar should be shown or hidden
     *
     * @return Boolean, true - will be shown, false - will be hidden
     */
    protected open fun canShowActionBar(): Boolean = true

    /**
     * Method returns title for ActionBar
     *
     * @return Nullable String
     */
    protected open fun getActionBarTitle(): String? = null

    /**
     * Method call when ViewModel created but not applied to ViewBinding
     *
     * @param isViewRestored Indicates that View is restored or recreated
     */
    protected abstract fun onViewModelCreated(isViewRestored: Boolean)

    /**
     * Method returns ViewBinding instance
     *
     * @param inflater Layout inflater
     * @param container Root container
     * @return ViewBinding instance
     */
    protected abstract fun getViewBindingInstance(inflater: LayoutInflater, container: ViewGroup?): A

    /**
     * Method return ViewModel class
     *
     * @return class of ViewModel
     */
    protected abstract fun getViewModelClass(): Class<B>

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean("isRestoredState_${javaClass.simpleName}", true)
        super.onSaveInstanceState(outState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = getViewBindingInstance(inflater, container)
        viewBinding?.lifecycleOwner = this
        return viewBinding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        savedInstanceState?.let {
            isRestoredState = it.getBoolean("isRestoredState_${javaClass.simpleName}", false)
        }
        viewModel = ViewModelProviders.of(this).get(getViewModelClass())
        onViewModelCreated(isRestoredState)
        isRestoredState = false
        setViewModelToViewBinding(viewModel)
    }

    override fun onResume() {
        super.onResume()
        updateActionBar()
    }

    /**
     * Method updates ActionBar visibility and title
     * If getActionBarTitle is not null then title will be applied to ActionBar
     * @see canShowActionBar
     * @see getActionBarTitle
     */
    fun updateActionBar() {
        if (activity != null && activity is AppCompatActivity) {
            (activity as AppCompatActivity).supportActionBar?.let { actionBar ->
                if (canShowActionBar())
                    actionBar.show()
                else
                    actionBar.hide()
                getActionBarTitle()?.let { title -> actionBar.title = title }
            }
        }
    }

    override fun onDestroy() {
        setViewModelToViewBinding(null)
        viewModel = null
        viewBinding = null
        super.onDestroy()
    }

    /**
     * Method apply ViewModel instance to ViewBinding
     */
    private fun setViewModelToViewBinding(value: B?) {
        try {
            viewBinding?.let { vb ->
                viewModel?.let { vm ->
                    val method = vb.javaClass.getDeclaredMethod("setViewModel", vm.javaClass)
                    method.invoke(vb, value)
                }
            }
        } catch (ex: Throwable) {
        }
    }
}