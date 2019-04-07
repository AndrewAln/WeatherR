package basaraba.andrii.weatherr.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import basaraba.andrii.weatherr.model.weather.ResponseWeather
import basaraba.andrii.weatherr.repository.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class WeatherViewModel(private val repository: Repository) : ViewModel() {

    private lateinit var subscription: Disposable

    val weather = MutableLiveData<ResponseWeather>()

    init {
        getWeather()
    }

    private fun getWeather() {
        subscription = repository.getWeather().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ weather.value = it },
                { })
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}