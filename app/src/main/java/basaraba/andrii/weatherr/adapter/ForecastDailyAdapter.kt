package basaraba.andrii.weatherr.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import basaraba.andrii.weatherr.*
import basaraba.andrii.weatherr.model.forecast.Forecast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_row_daily.view.*

class ForecastDailyAdapter : RecyclerView.Adapter<ForecastDailyAdapter.ForecastHolder>() {

    private var listForecast: ArrayList<Forecast> = ArrayList()

    fun addListForecast(listForecast: ArrayList<Forecast>) {
        this.listForecast.addAll(listForecast)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ForecastDailyAdapter.ForecastHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_daily, parent, false)
        return ForecastHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listForecast.size
    }

    override fun onBindViewHolder(holder: ForecastDailyAdapter.ForecastHolder, position: Int) {
        holder.onBind(listForecast[position])
    }

    class ForecastHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val view = view

        fun onBind(forecast: Forecast) {
            view.tvRowDailyTemp.text = forecast.weatherInformation.temp.convertDoubleToTemperature()
            view.tvRowDailyDate.text = forecast.dateForecast.formatToDate()
            view.tvRowDailyDay.text = forecast.dateForecast.formatToDay()
            view.tvRowDailyMonth.text = forecast.dateForecast.formatToMonth()
            view.tvRowDailyHumidity.text =
                view.context.getString(R.string.convert_humidity, forecast.weatherInformation.humidity)
            view.tvRowDailyWind.text =
                view.context.getString(R.string.convert_speed_daily, forecast.wind.speed.convertSpeed())
            view.tvRowDailyWeather.text = forecast.weatherCondition[0].description.capitalize()
            Glide.with(view.context).load(forecast.weatherCondition[0].icon.getIcon()).into(view.igRowDaily)
        }
    }
}