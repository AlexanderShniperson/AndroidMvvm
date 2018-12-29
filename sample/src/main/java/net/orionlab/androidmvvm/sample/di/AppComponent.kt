package net.orionlab.androidmvvm.sample.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import net.orionlab.androidmvvm.sample.MainActivity
import net.orionlab.androidmvvm.sample.di.module.NavigationModule
import net.orionlab.androidmvvm.sample.viewModel.*
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Singleton
@Component(modules = [NavigationModule::class])
interface AppComponent {
    fun provideContext(): Context
    fun provideRouter(): Router

    fun inject(value: MainActivity)
    fun inject(value: FirstViewModel)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        @BindsInstance
        fun context(context: Context): Builder
    }

    class Initializer private constructor() {
        companion object {
            fun init(context: Context): AppComponent =
                DaggerAppComponent.builder()
                    .context(context)
                    .build()
        }
    }
}