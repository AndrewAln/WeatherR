package basaraba.andrii.weatherr.fragments

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
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class FragmentForecastToday : Fragment() {

    private val todayViewModel: ForecastTodayViewModel by viewModel()
    private val forecastTodayAdapter: ForecastTodayAdapter by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_forecast_today, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        todayViewModel.forecast.observe(this, Observer { result -> fillRecycler(result) })
        rvToday?.adapter = forecastTodayAdapter
        rvToday?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun fillRecycler(forecast: ResponseForecast?) {
        forecastTodayAdapter.addListForecast(forecast?.list!!)

        tvForecastWind.text = getString(R.string.convert_speed_today, forecast.list[0].wind.speed.convertSpeed())
        tvForecastPressure.text =
            getString(R.string.convert_pressure, forecast.list[0].weatherInformation.pressure.toInt())
        tvForecastHumidity.text = getString(R.string.convert_humidity, forecast.list[0].weatherInformation.humidity)
    }
}