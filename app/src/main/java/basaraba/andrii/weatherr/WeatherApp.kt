package basaraba.andrii.weatherr

import android.app.Application
import basaraba.andrii.weatherr.di.DependenciesModules
import org.koin.core.context.startKoin

class WeatherApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                listOf(
                    DependenciesModules().viewModule,
                    DependenciesModules().apiModule,
                    DependenciesModules().repoModule,
                    DependenciesModules().adapterModule
                )
            )
        }
    }
}