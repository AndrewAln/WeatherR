package basaraba.andrii.weatherr.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import basaraba.andrii.weatherr.R
import basaraba.andrii.weatherr.convertDoubleToString
import basaraba.andrii.weatherr.formatToDate
import basaraba.andrii.weatherr.getIcon
import basaraba.andrii.weatherr.model.forecast.Forecast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_row_today.view.*


class ForecastTodayAdapter(private val context: Context) : RecyclerView.Adapter<ForecastTodayAdapter.ForecastHolder>() {

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
        val forecast = listForecast[position]

        holder.textTemp.text = forecast.weatherInformation.temp.convertDoubleToString()
        holder.textTime.text = forecast.dateForecast.formatToDate()
        Glide.with(context).load(forecast.weatherCondition[0].icon.getIcon()).into(holder.imageIcon)
    }

    class ForecastHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textTime = view.tvRowTodayTime
        val textTemp = view.tvRowTodayTemp
        val imageIcon = view.igRowToday

    }
}