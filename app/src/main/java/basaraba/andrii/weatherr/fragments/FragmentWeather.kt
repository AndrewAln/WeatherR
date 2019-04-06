package basaraba.andrii.weatherr.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import basaraba.andrii.weatherr.R
import basaraba.andrii.weatherr.convertDoubleToString
import basaraba.andrii.weatherr.getIcon
import basaraba.andrii.weatherr.model.weather.ResponseWeather
import basaraba.andrii.weatherr.ui.WeatherViewModel
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_weather.*

class FragmentWeather : Fragment() {

    private lateinit var viewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(WeatherViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_weather, container, false)
        viewModel.weather.observe(this, Observer { result -> initView(result) })
        return view
    }

    private fun initView(weather: ResponseWeather?) {

        tvWeatherTemp.text = weather?.weatherInformation?.temp?.convertDoubleToString()
        tvWeatherDesc.text = weather?.weatherCondition?.get(0)?.description?.capitalize()
        Glide.with(context!!).load(weather?.weatherCondition!![0].icon.getIcon()).into(igWeatherIcon)
    }
}