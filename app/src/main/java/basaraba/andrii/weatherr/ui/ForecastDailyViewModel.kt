package basaraba.andrii.weatherr.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import basaraba.andrii.weatherr.model.forecast.ResponseForecast
import basaraba.andrii.weatherr.repository.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ForecastDailyViewModel(private val repository: Repository) : ViewModel() {
    private lateinit var subscription: Disposable

    val forecast = MutableLiveData<ResponseForecast>()

    init {
        getForecastDaily()
    }

    private fun getForecastDaily() {
        subscription = repository.getForecastDaily().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ forecast.value = it },
                {})
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}