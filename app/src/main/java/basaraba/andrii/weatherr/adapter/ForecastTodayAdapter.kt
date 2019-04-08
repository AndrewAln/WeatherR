package basaraba.andrii.weatherr.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import basaraba.andrii.weatherr.R
import basaraba.andrii.weatherr.convertDoubleToTemperature
import basaraba.andrii.weatherr.formatToDate
import basaraba.andrii.weatherr.getIcon
import basaraba.andrii.weatherr.model.forecast.Forecast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_row_today.view.*


class ForecastTodayAdapter : RecyclerView.Adapter<ForecastTodayAdapter.ForecastHolder>() {

    private var listForecast: ArrayList<Forecast> = ArrayList()

    fun addListForecast(listForecast: ArrayList<Forecast>) {
        this.listForecast.addAll(listForecast)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ForecastTodayAdapter.ForecastHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_today, parent, false)
        return ForecastHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listForecast.size
    }

    override fun onBindViewHolder(holder: ForecastTodayAdapter.ForecastHolder, position: Int) {
        holder.onBind(listForecast[position])
    }

    class ForecastHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val view = view

        fun onBind(forecast: Forecast) {
            view.tvRowTodayTemp.text = forecast.weatherInformation.temp.convertDoubleToTemperature()
            view.tvRowTodayTime.text = forecast.dateForecast.formatToDate()
            Glide.with(view.context).load(forecast.weatherCondition[0].icon.getIcon()).into(view.igRowToday)
        }

    }
}