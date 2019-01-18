[![Release](https://jitpack.io/v/AlexanderShniperson/AndroidMvvm.svg)](https://jitpack.io/#AlexanderShniperson/AndroidMvvm)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-AndroidMvvm-green.svg?style=flat)](https://android-arsenal.com/details/1/7466)
# AndroidMvvm
Library describes experience how to implement and use of MVVM pattern provided by Google.<br>
Project include example of usage.

## Library integration
This library is available in [JitPack.io](https://jitpack.io/) repository.
1) make sure to add the below inside root `build.gradle` file
```
allprojects {
    repositories {
        mavenCentral()
        maven { url "https://jitpack.io" }
    }
}
```
2) add library dependency to the app's `build.gradle` file.
```
dependencies {
   implementation 'com.github.AlexanderShniperson:AndroidMvvm:1.0'
}
```

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
