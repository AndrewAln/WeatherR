package basaraba.andrii.weatherr.di

import basaraba.andrii.weatherr.network.RetrofitClient
import basaraba.andrii.weatherr.repository.Repository
import basaraba.andrii.weatherr.ui.ForecastViewModel
import basaraba.andrii.weatherr.ui.WeatherViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

class DependenciesModules {
    val appModule = module {

        factory { RetrofitClient().getService() }

        factory { Repository(get()) }

        viewModel { WeatherViewModel(get()) }

        viewModel { ForecastViewModel(get()) }
    }
}