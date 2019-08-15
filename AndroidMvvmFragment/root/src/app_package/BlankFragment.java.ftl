package ${packageName};

import net.orionlab.androidmvvm.MvvmFragment;
import ${packageName}.${viewModelName};
import ${applicationPackage}.databinding.${underscoreToCamelCase(layoutName)}Binding;

public class ${className} extends MvvmFragment<${underscoreToCamelCase(layoutName)}Binding, ${viewModelName}> {
    @Override
    ${underscoreToCamelCase(layoutName)}Binding getViewBindingInstance(
                LayoutInflater inflater,
                ViewGroup container
        ) {
        return ${underscoreToCamelCase(layoutName)}Binding.inflate(inflater, container, false);
    }

    @Override
    Class<${viewModelName}> getViewModelClass() {
        return ${viewModelName}.class;
    }

    @Override
    void onViewModelCreated(Boolean isViewRestored) {
        // TODO implement interaction with viewBinding and viewModel here
    }
}
