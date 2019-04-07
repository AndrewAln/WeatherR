package basaraba.andrii.weatherr.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import basaraba.andrii.weatherr.CITY_WEATHER
import basaraba.andrii.weatherr.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvToolbar.text = CITY_WEATHER.toUpperCase()
    }
}