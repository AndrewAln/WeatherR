package basaraba.andrii.weatherr.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import basaraba.andrii.weatherr.R
import basaraba.andrii.weatherr.model.forecast.Forecast
import kotlinx.android.synthetic.main.item_row_today.view.*

class ForecastTodayAdapter : RecyclerView.Adapter<ForecastTodayAdapter.ForecastHolder>() {

    private var listForecast: ArrayList<Forecast> = ArrayList()

    fun addListForecast(listForecast: ArrayList<Forecast>) {
        this.listForecast.addAll(listForecast)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ForecastTodayAdapter.ForecastHolder {
        var itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_today, parent, false);
        return ForecastHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listForecast.size
    }

    override fun onBindViewHolder(holder: ForecastTodayAdapter.ForecastHolder, position: Int) {
        val forecast = listForecast[position]

        holder.textTemp.text = "+${forecast.weatherInformation.temp}"
        holder.textTime.text = "12:00"
    }

    class ForecastHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textTime = view.tvRowTodayTime
        val textTemp = view.tvRowTodayTemp
        val imageIcon = view.igRowToday

    }
}