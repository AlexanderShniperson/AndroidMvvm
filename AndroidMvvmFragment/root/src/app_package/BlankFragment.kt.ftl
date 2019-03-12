package ${escapeKotlinIdentifiers(packageName)}

import net.orionlab.androidmvvm.MvvmFragment
import ${escapeKotlinIdentifiers(packageName)}.${viewModelName}
import ${escapeKotlinIdentifiers(applicationPackage)}.databinding.${underscoreToCamelCase(layoutName)}Binding

class ${className} : MvvmFragment<${underscoreToCamelCase(layoutName)}Binding, ${viewModelName}>() {
    override fun onMvvmComponentInit() {
        // TODO implement interaction with view and viewModel here
    }
}
