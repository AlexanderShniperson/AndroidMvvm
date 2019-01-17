[![Release](https://jitpack.io/v/AlexanderShniperson/AndroidMvvm.svg)](https://jitpack.io/#AlexanderShniperson/AndroidMvvm)
# AndroidMvvm
Library describes experience how to implement and use of MVVM pattern provided by Google.<br>
Project include example of usage.

## How to use
1) Create `Fragment` with `ViewModel` from Menu<br>
`File > Fragment > Fragment + ViewModel`<br>
2) Put inside your Fragment layout into `layout` DataBinding tag<br>
```
<layout>
<FrameLayout>
...
</FrameLayout>
</layout>
```
3) Extend your new created `Fragment` class from `MvvmFragment`, provide `ViewBinding` and `ViewModel` generic classes, implement `onMvvmComponentInit` method<br>
```
class NewFragment: MvvmFragment<NewFragmentBinding, NewFragmentViewModel>() {

override fun onMvvmComponentInit() {
  // do any stuff with ViewBinding and ViewModel
}
...
}
```
4) Extend your new created `ViewModel` from `MvvmAndroidViewModel`<br>
5) You are done, do any implementations at your `ViewModel` as described at Sample project<br>
