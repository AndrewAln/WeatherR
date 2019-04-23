package basaraba.andrii.weatherr.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import basaraba.andrii.weatherr.model.weather.ResponseWeather
import basaraba.andrii.weatherr.repository.WeatherRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class WeatherViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {

    private var subscription: Disposable? = null

    val weather = MutableLiveData<ResponseWeather>()

    init {
        getWeather()
    }

    private fun getWeather() {
        subscription = weatherRepository.getWeather().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ weather.value = it },
                { })
    }

    override fun onCleared() {
        super.onCleared()
        if (subscription != null)
            subscription?.dispose()
    }
}