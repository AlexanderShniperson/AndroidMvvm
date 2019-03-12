-dontobfuscate
# See https://speakerdeck.com/chalup/proguard
-optimizations !code/allocation/variable

-keepattributes Signature

-keep public class * {
    public protected *;
}

-dontwarn androidx.databinding.**
-keep class androidx.databinding.** { *; }

-keep class net.orionlab.androidmvvm.** { *; }
-dontnote net.orionlab.androidmvvm.MvvmFragment