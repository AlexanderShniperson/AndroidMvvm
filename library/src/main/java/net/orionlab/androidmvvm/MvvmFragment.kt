package net.orionlab.androidmvvm

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import java.lang.reflect.ParameterizedType

abstract class MvvmFragment<A : ViewDataBinding, B : MvvmAndroidViewModel> : Fragment() {
    var viewBinding: A? = null
    var viewModel: B? = null

    interface OnBackPressedListener {
        fun onBackPressed(): Boolean = false
    }

    open fun canShowActionBar(): Boolean = true

    open fun getScreenTitle(): String? = null

    abstract fun onMvvmComponentInit()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = getViewBindingInstance(inflater, container)
        viewBinding?.lifecycleOwner = this
        return viewBinding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(getViewModelClass())
        setViewModelToViewBinding(viewModel)
    }

    override fun onResume() {
        super.onResume()
        onMvvmComponentInit()
        updateActionBar()
    }

    fun updateActionBar() {
        if (activity != null && activity is AppCompatActivity) {
            (activity as AppCompatActivity).supportActionBar?.let { actionBar ->
                if (canShowActionBar())
                    actionBar.show()
                else
                    actionBar.hide()
                getScreenTitle()?.let { title -> actionBar.title = title }
            }
        }
    }

    override fun onDestroy() {
        setViewModelToViewBinding(null)
        viewModel?.onDestroy()
        viewModel = null
        viewBinding = null
        super.onDestroy()
    }

    @Suppress("UNCHECKED_CAST")
    private fun getViewBindingInstance(layoutInflater: LayoutInflater, container: ViewGroup?): A {
        val clazz = ((this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<A>)
        val method =
            clazz.getDeclaredMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)
        return method.invoke(clazz, layoutInflater, container, false) as A
    }

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

    @Suppress("UNCHECKED_CAST")
    private fun getViewModelClass(): Class<B> {
        return ((this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[1] as Class<B>)
    }
}