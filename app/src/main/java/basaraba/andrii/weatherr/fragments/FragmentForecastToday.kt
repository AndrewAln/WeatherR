package basaraba.andrii.weatherr.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import basaraba.andrii.weatherr.R
import basaraba.andrii.weatherr.adapter.ForecastTodayAdapter
import basaraba.andrii.weatherr.model.forecast.ResponseForecast
import basaraba.andrii.weatherr.ui.ForecastViewModel
import kotlinx.android.synthetic.main.fragment_forecast_today.*

class FragmentForecastToday : Fragment() {

    private lateinit var viewModel: ForecastViewModel
    private lateinit var forecastTodayAdapter: ForecastTodayAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ForecastViewModel::class.java)
        forecastTodayAdapter = ForecastTodayAdapter(context!!)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_forecast_today, container, false)
        viewModel.forecast.observe(this, Observer { result -> fillRecycler(result) })
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.rvToday?.adapter = forecastTodayAdapter
        activity?.rvToday?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun fillRecycler(forecast: ResponseForecast?) {
        forecastTodayAdapter.addListForecast(forecast?.list!!)

        tvForecastWind.text = "${forecast.list[0].wind.speed.toInt()} km/h SE"
        tvForecastPressure.text = "${forecast.list[0].weatherInformation.pressure.toInt()} mmHg"
        tvForecastHumidity.text = "${forecast.list[0].weatherInformation.humidity}%"

    }
}