[![Release](https://jitpack.io/v/AlexanderShniperson/AndroidMvvm.svg)](https://jitpack.io/#AlexanderShniperson/AndroidMvvm)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-AndroidMvvm-green.svg?style=flat)](https://android-arsenal.com/details/1/7466)
# AndroidMvvm
Library describes experience how to implement and use MVVM pattern provided by Google.<br>
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
   implementation 'com.github.AlexanderShniperson:AndroidMvvm:1.1'
}
```

## How to use
1) Copy Template files from `AndroidMvvmFragment` into
a) Windows `C:\Program Files\Android\Android Studio\plugins\android\lib\templates\other\`
b) MacOS `/Applications/Android Studio.app/Contents/plugins/android/lib/templates/other/`
2) Restart `Android Studio` if it was launched before
3) Create `AndroidMvvm Fragment + ViewModel` from Menu<br>
`File > Fragment > AndroidMvvm Fragment + ViewModel`<br>
4) Fill `Template name` field and click `Finish`
5) You are done, do any implementations at your `ViewModel` as described at Sample project
