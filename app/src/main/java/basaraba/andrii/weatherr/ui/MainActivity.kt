package basaraba.andrii.weatherr.ui

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.v7.app.AppCompatActivity
import basaraba.andrii.weatherr.CITY_WEATHER
import basaraba.andrii.weatherr.R
import basaraba.andrii.weatherr.getColorFromAttr
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvToolbar.text = CITY_WEATHER.toUpperCase()
        initOnOffSetChangedListener()
    }

    private fun initOnOffSetChangedListener() {
        appbar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { p0, p1 ->
            if (Math.abs(p1) - p0!!.totalScrollRange == 0) {
                tvToolbar.setTextColor(getColorFromAttr(R.attr.colorPrimary))
                toolbarMain.setBackgroundColor(Color.WHITE)
            } else {
                tvToolbar.setTextColor(Color.WHITE)
                toolbarMain.setBackgroundColor(getColorFromAttr(R.attr.colorPrimary))
            }
        })
    }
}