package basaraba.andrii.weatherr.network

import basaraba.andrii.weatherr.model.forecast.ResponseForecast
import basaraba.andrii.weatherr.model.weather.ResponseWeather
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherService {
    @GET("weather")
    fun getWeatherCity(
        @Query("appid") apiKey: String,
        @Query("q") query: String,
        @Query("units") units: String
    ): Single<ResponseWeather>

    @GET("forecast/hourly")
    fun getForecast(
        @Query("appid") apiKey: String,
        @Query("q") query: String,
        @Query("units") units: String
    ): Single<ResponseForecast>
}