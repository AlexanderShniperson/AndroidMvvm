package ${escapeKotlinIdentifiers(packageName)}

import net.orionlab.androidmvvm.MvvmFragment
import ${escapeKotlinIdentifiers(packageName)}.${viewModelName}
import ${escapeKotlinIdentifiers(applicationPackage)}.databinding.${underscoreToCamelCase(layoutName)}Binding

class ${className} : MvvmFragment<${underscoreToCamelCase(layoutName)}Binding, ${viewModelName}>() {
    override fun getViewBindingInstance(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ${underscoreToCamelCase(layoutName)}Binding {
        return ${underscoreToCamelCase(layoutName)}Binding.inflate(inflater, container, false)
    }

    override fun getViewModelClass(): Class<${viewModelName}> {
        return ${viewModelName}::class.java
    }

    override fun onViewModelCreated(isViewRestored: Boolean) {
        // TODO implement interaction with viewBinding and viewModel here
    }
}
