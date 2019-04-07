package basaraba.andrii.weatherr.fragments

import android.arch.lifecycle.Observer
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
import kotlinx.android.synthetic.main.fragment_weather.*
import org.koin.android.viewmodel.ext.android.viewModel

class FragmentWeather : Fragment() {

    private val viewModel: WeatherViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.weather.observe(this, Observer { result -> initView(result) })
    }

    private fun initView(weather: ResponseWeather?) {
        tvWeatherTemp.text = weather?.weatherInformation?.temp?.convertDoubleToString()
        tvWeatherDesc.text = weather?.weatherCondition?.get(0)?.description?.capitalize()
        Glide.with(context!!).load(weather?.weatherCondition!![0].icon.getIcon()).into(igWeatherIcon)
    }
}