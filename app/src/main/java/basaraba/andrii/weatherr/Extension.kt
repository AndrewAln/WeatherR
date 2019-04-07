package basaraba.andrii.weatherr

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*


fun String.getIcon(): Int {
    return when (this) {
        "01d" -> R.drawable.ic_clear_sky_day
        "01n" -> R.drawable.ic_clear_sky_night
        "02d" -> R.drawable.ic_few_clouds_day
        "02n" -> R.drawable.ic_few_clouds_night
        "03d" -> R.drawable.ic_scattered_clouds
        "03n" -> R.drawable.ic_scattered_clouds
        "04d" -> R.drawable.ic_broken_clouds
        "04n" -> R.drawable.ic_broken_clouds
        "09d" -> R.drawable.ic_shower_rain
        "09n" -> R.drawable.ic_shower_rain
        "10d" -> R.drawable.ic_rain_day
        "10n" -> R.drawable.ic_rain_night
        "11d" -> R.drawable.ic_thunderstorm
        "11n" -> R.drawable.ic_thunderstorm
        "13d" -> R.drawable.ic_snow
        "13n" -> R.drawable.ic_snow
        "50d" -> R.drawable.ic_mist
        "50n" -> R.drawable.ic_mist
        else -> R.drawable.ic_launcher_background
    }
}

fun Double.convertSpeed(): Int {
    return (this * 3.6).toInt()
}

fun Double.convertDoubleToString(): String {
    val temp = this.toInt()
    return if (temp > 0)
        "+$temp°"
    else
        "-$temp°"
}

@SuppressLint("SimpleDateFormat")
fun String.formatToDate(): String {
    return SimpleDateFormat("HH:mm").format(SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(this))
}

@SuppressLint("SimpleDateFormat")
fun String.formatToDay(): String {
    return SimpleDateFormat("EEEE", Locale.ENGLISH).format(SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(this)).capitalize()
}

@SuppressLint("SimpleDateFormat")
fun String.formatToMonth(): String {
    return SimpleDateFormat("MMMM d", Locale.ENGLISH).format(SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(this)).capitalize()
}