package net.orionlab.androidmvvm

import android.arch.lifecycle.ViewModelProviders
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.lang.reflect.ParameterizedType

abstract class MvvmFragment<A : ViewDataBinding, B : MvvmAndroidViewModel> : Fragment() {
    lateinit var viewBinding: A
    lateinit var viewModel: B

    open fun canShowActionBar(): Boolean = true

    open fun getScreenTitle(): String? = null

    abstract fun onMvvmComponentInit()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = getViewBindingInstance(inflater, container)
        return viewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(getViewModelClass())
        setViewModelToViewBinding(viewModel)
        onMvvmComponentInit()
    }

    override fun onDestroy() {
        super.onDestroy()
        setViewModelToViewBinding(null)
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
            val method = viewBinding.javaClass.getDeclaredMethod("setViewModel", viewModel.javaClass)
            method.invoke(viewBinding, value)
        } catch (ex: Throwable) {
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun getViewModelClass(): Class<B> {
        return ((this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[1] as Class<B>)
    }
}