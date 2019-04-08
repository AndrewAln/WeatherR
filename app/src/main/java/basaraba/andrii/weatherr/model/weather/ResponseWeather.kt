package basaraba.andrii.weatherr.model.weather

import basaraba.andrii.weatherr.model.forecast.SystemParameters
import basaraba.andrii.weatherr.model.forecast.WeatherCondition
import basaraba.andrii.weatherr.model.forecast.WeatherInformation
import basaraba.andrii.weatherr.model.forecast.Wind
import com.google.gson.annotations.SerializedName

data class ResponseWeather(
    @SerializedName("coord")
    val coordinates: Coordinates,
    @SerializedName("weather")
    val weatherCondition: List<WeatherCondition>,
    @SerializedName("base")
    val internalParameter: String,
    @SerializedName("main")
    val weatherInformation: WeatherInformation,
    @SerializedName("wind")
    val wind: Wind,
    @SerializedName("clouds")
    val clouds: Clouds,
    @SerializedName("dt")
    val lastUpdate: Int,
    @SerializedName("sys")
    val systemParameters: SystemParameters,
    @SerializedName("id")
    val cityId: Int,
    @SerializedName("name")
    val cityName: String,
    @SerializedName("cod")
    val parameter: Int
)

data class Clouds(
    @SerializedName("all") val cloudsPercent: Int
)

data class Coordinates(
    @SerializedName("lon") val lon: Double,
    @SerializedName("lat") val lat: Double
)

data class WeatherInformation(
    @SerializedName("temp") val temp: Double,
    @SerializedName("pressure") val pressure: Double,
    @SerializedName("humidity") val humidity: Int,
    @SerializedName("temp_min") val tempMin: Double,
    @SerializedName("temp_max") val tempMax: Double,
    @SerializedName("sea_level") val seaLevel: Double,
    @SerializedName("grnd_level") val groundLevel: Double
)

data class SystemParameters(
    @SerializedName("message") val message: Double,
    @SerializedName("country") val country: String,
    @SerializedName("sunrise") val sunrise: Int,
    @SerializedName("sunset") val sunset: Int
)

data class WeatherCondition(
    @SerializedName("id") val weatherId: Int,
    @SerializedName("main") val weatherParameters: String,
    @SerializedName("description") val description: String,
    @SerializedName("icon") val icon: String
)

data class Wind(
    @SerializedName("speed") val speed: Double,
    @SerializedName("deg") val deg: Double
)