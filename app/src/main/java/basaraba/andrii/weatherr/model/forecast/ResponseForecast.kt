package basaraba.andrii.weatherr.model.forecast

import basaraba.andrii.weatherr.model.weather.Clouds
import basaraba.andrii.weatherr.model.weather.Coordinates
import basaraba.andrii.weatherr.model.weather.SystemParameters
import basaraba.andrii.weatherr.model.weather.WeatherCondition
import basaraba.andrii.weatherr.model.weather.WeatherInformation
import basaraba.andrii.weatherr.model.weather.Wind
import com.google.gson.annotations.SerializedName

data class ResponseForecast(

    @SerializedName("cod") val cod: Int,
    @SerializedName("message") val message: Double,
    @SerializedName("cnt") val linesReturned: Int,
    @SerializedName("list") val list: ArrayList<Forecast>,
    @SerializedName("city") val cityInformation: CityInformation
)

data class Forecast(

    @SerializedName("dt") val dt: Int,
    @SerializedName("main") val weatherInformation: WeatherInformation,
    @SerializedName("weather") val weatherCondition: List<WeatherCondition>,
    @SerializedName("clouds") val clouds: Clouds,
    @SerializedName("wind") val wind: Wind,
    @SerializedName("sys") val systemParameters: SystemParameters,
    @SerializedName("dt_txt") val dateForecast: String
)

data class Clouds(
    @SerializedName("all") val cloudsPercent: Int
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

data class CityInformation(

    @SerializedName("id") val cityId: Int,
    @SerializedName("name") val cityName: String,
    @SerializedName("coord") val coordinates: Coordinates,
    @SerializedName("country") val country: String,
    @SerializedName("population") val population: Int
)

data class Coordinates(

    @SerializedName("lon") val lon: Double,
    @SerializedName("lat") val lat: Double
)

