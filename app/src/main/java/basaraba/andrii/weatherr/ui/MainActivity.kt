package basaraba.andrii.weatherr.ui

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import basaraba.andrii.weatherr.CITY_WEATHER
import basaraba.andrii.weatherr.R
import basaraba.andrii.weatherr.adapter.ForecastTodayAdapter
import basaraba.andrii.weatherr.model.forecast.ResponseForecast
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: ForecastViewModel by viewModel()
    private lateinit var forecastTodayAdapter: ForecastTodayAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forecastTodayAdapter = ForecastTodayAdapter(this)
        tvToolbar.text = CITY_WEATHER.toUpperCase()
        rvDaily.adapter = forecastTodayAdapter
        rvDaily.layoutManager = LinearLayoutManager(application)
        viewModel.forecast.observe(this, Observer { result -> fillRecycler(result) })
    }

    private fun fillRecycler(forecast: ResponseForecast?) {
        forecastTodayAdapter.addListForecast(forecast?.list!!)

    }
}
