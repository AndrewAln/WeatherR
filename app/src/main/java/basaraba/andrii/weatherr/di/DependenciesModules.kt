package basaraba.andrii.weatherr.di

import basaraba.andrii.weatherr.adapter.ForecastDailyAdapter
import basaraba.andrii.weatherr.adapter.ForecastTodayAdapter
import basaraba.andrii.weatherr.network.RetrofitClient
import basaraba.andrii.weatherr.repository.WeatherRepository
import basaraba.andrii.weatherr.ui.ForecastDailyViewModel
import basaraba.andrii.weatherr.ui.ForecastTodayViewModel
import basaraba.andrii.weatherr.ui.WeatherViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

class DependenciesModules {

    val apiModule = module {
        single { RetrofitClient().getService(get()) }
        single { RetrofitClient().getRetrofitService() }
    }

    val adapterModule = module {
        single { ForecastDailyAdapter() }
        single { ForecastTodayAdapter() }
    }

    val repoModule = module { single { WeatherRepository(get()) } }

    val viewModule = module {

        viewModel { WeatherViewModel(get()) }

        viewModel { ForecastTodayViewModel(get()) }

        viewModel { ForecastDailyViewModel(get()) }
    }
}