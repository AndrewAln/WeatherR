package basaraba.andrii.weatherr.fragments

import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import basaraba.andrii.weatherr.R
import basaraba.andrii.weatherr.adapter.ForecastTodayAdapter
import basaraba.andrii.weatherr.convertSpeed
import basaraba.andrii.weatherr.model.forecast.ResponseForecast
import basaraba.andrii.weatherr.ui.ForecastTodayViewModel
import kotlinx.android.synthetic.main.fragment_forecast_today.*
import org.koin.android.viewmodel.ext.android.viewModel

class FragmentForecastToday : Fragment() {

    private val todayViewModel: ForecastTodayViewModel by viewModel()
    private lateinit var forecastTodayAdapter: ForecastTodayAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        forecastTodayAdapter = ForecastTodayAdapter(context!!)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_forecast_today, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        todayViewModel.forecast.observe(this, Observer { result -> fillRecycler(result) })
        rvToday?.adapter = forecastTodayAdapter
        rvToday?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    @SuppressLint("SetTextI18n")
    private fun fillRecycler(forecast: ResponseForecast?) {
        forecastTodayAdapter.addListForecast(forecast?.list!!)

        tvForecastWind.text = "${forecast.list[0].wind.speed.convertSpeed()} km/h SE"
        tvForecastPressure.text = "${forecast.list[0].weatherInformation.pressure.toInt()} mmHg"
        tvForecastHumidity.text = "${forecast.list[0].weatherInformation.humidity}%"
    }
}