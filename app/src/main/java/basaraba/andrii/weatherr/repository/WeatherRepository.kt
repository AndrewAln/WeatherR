package basaraba.andrii.weatherr.repository

import basaraba.andrii.weatherr.API_KEY
import basaraba.andrii.weatherr.CITY_WEATHER
import basaraba.andrii.weatherr.UNIT_SYSTEM
import basaraba.andrii.weatherr.model.forecast.ResponseForecast
import basaraba.andrii.weatherr.model.weather.ResponseWeather
import basaraba.andrii.weatherr.network.OpenWeatherService
import io.reactivex.Single


class WeatherRepository(private val openWeatherService: OpenWeatherService) {

    fun getWeather(): Single<ResponseWeather> =
        openWeatherService.getWeatherCity(API_KEY, CITY_WEATHER, UNIT_SYSTEM)

    fun getForecastToday(): Single<ResponseForecast> =
        openWeatherService.getForecastToday(API_KEY, CITY_WEATHER, UNIT_SYSTEM)

    fun getForecastDaily(): Single<ResponseForecast> =
        openWeatherService.getForecastDaily(API_KEY, CITY_WEATHER, UNIT_SYSTEM)
}
