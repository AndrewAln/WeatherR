package basaraba.andrii.weatherr.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import basaraba.andrii.weatherr.*
import basaraba.andrii.weatherr.model.forecast.Forecast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_row_daily.view.*

class ForecastDailyAdapter(private val context: Context) : RecyclerView.Adapter<ForecastDailyAdapter.ForecastHolder>() {

    private var listForecast: ArrayList<Forecast> = ArrayList()

    fun addListForecast(listForecast: ArrayList<Forecast>) {
        this.listForecast.addAll(listForecast)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ForecastDailyAdapter.ForecastHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_daily, parent, false);
        return ForecastHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listForecast.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ForecastDailyAdapter.ForecastHolder, position: Int) {
        val forecast = listForecast[position]

        holder.textTemp.text = forecast.weatherInformation.temp.convertDoubleToString()
        holder.textDate.text = forecast.dateForecast.formatToDate()
        holder.textDay.text = forecast.dateForecast.formatToDay()
        holder.textMonth.text = forecast.dateForecast.formatToMonth()
        holder.textHumidity.text = "${forecast.weatherInformation.humidity} %"
        holder.textWind.text = "SE ${forecast.wind.speed.convertSpeed()} km/h"
        holder.textWeather.text = forecast.weatherCondition[0].description.capitalize()
        Glide.with(context).load(forecast?.weatherCondition!![0].icon.getIcon()).into(holder.imageIcon)
    }

    class ForecastHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageIcon = view.igRowDaily
        val textTemp = view.tvRowDailyTemp
        val textWeather = view.tvRowDailyWeather
        val textHumidity = view.tvRowDailyHumidity
        val textWind = view.tvRowDailyWind
        val textDate = view.tvRowDailyDate
        val textDay = view.tvRowDailyDay
        val textMonth = view.tvRowDailyMonth

    }
}