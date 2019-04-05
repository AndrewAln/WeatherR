package basaraba.andrii.weatherr.repository

import basaraba.andrii.weatherr.API_KEY
import basaraba.andrii.weatherr.CITY_WEATHER
import basaraba.andrii.weatherr.UNIT_SYSTEM
import basaraba.andrii.weatherr.model.forecast.ResponseForecast
import basaraba.andrii.weatherr.model.weather.ResponseWeather
import basaraba.andrii.weatherr.network.RetrofitClient
import io.reactivex.Single


class Repository {

    fun getWeather(): Single<ResponseWeather> =
        RetrofitClient().getService().getWeatherCity(API_KEY, CITY_WEATHER, UNIT_SYSTEM)

    fun getForecast(): Single<ResponseForecast> =
        RetrofitClient().getService().getForecast(API_KEY, CITY_WEATHER, UNIT_SYSTEM)

}
