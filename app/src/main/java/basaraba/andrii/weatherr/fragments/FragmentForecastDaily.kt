package basaraba.andrii.weatherr.fragments

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import basaraba.andrii.weatherr.R
import basaraba.andrii.weatherr.adapter.ForecastDailyAdapter
import basaraba.andrii.weatherr.model.forecast.ResponseForecast
import basaraba.andrii.weatherr.ui.ForecastDailyViewModel
import kotlinx.android.synthetic.main.fragment_forecast_daily.*
import org.koin.android.viewmodel.ext.android.viewModel

class FragmentForecastDaily : Fragment() {

    private val dailyViewModel: ForecastDailyViewModel by viewModel()
    private lateinit var forecastDailyAdapter: ForecastDailyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        forecastDailyAdapter = ForecastDailyAdapter(context!!)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_forecast_daily, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        dailyViewModel.forecast.observe(this, Observer { result -> fillRecycler(result) })

        activity?.rvDaily?.adapter = forecastDailyAdapter
        activity?.rvDaily?.layoutManager = LinearLayoutManager(context)
    }

    private fun fillRecycler(forecast: ResponseForecast?) {
        forecastDailyAdapter.addListForecast(forecast?.list!!)
    }
}