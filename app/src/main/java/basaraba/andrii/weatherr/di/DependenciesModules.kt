package basaraba.andrii.weatherr.di

import basaraba.andrii.weatherr.network.RetrofitClient
import basaraba.andrii.weatherr.repository.Repository
import basaraba.andrii.weatherr.ui.ForecastDailyViewModel
import basaraba.andrii.weatherr.ui.ForecastTodayViewModel
import basaraba.andrii.weatherr.ui.WeatherViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

class DependenciesModules {

    val apiModule = module { factory { RetrofitClient().getService() } }

    val repoModule = module { factory { Repository(get()) } }

    val viewModule = module {

        viewModel { WeatherViewModel(get()) }

        viewModel { ForecastTodayViewModel(get()) }

        viewModel { ForecastDailyViewModel(get()) }
    }
}