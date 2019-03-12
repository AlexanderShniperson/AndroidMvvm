package ${packageName};

import net.orionlab.androidmvvm.MvvmFragment;
import ${packageName}.${viewModelName};
import ${applicationPackage}.databinding.${underscoreToCamelCase(layoutName)}Binding;

public class ${className} extends MvvmFragment<${underscoreToCamelCase(layoutName)}Binding, ${viewModelName}> {
    @Override
    public void onMvvmComponentInit() {
        // TODO implement interaction with view and viewModel here
    }
}
