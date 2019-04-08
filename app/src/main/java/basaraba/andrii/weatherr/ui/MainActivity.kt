package basaraba.andrii.weatherr.ui

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.v7.app.AppCompatActivity
import android.view.View
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
                window.statusBarColor = Color.WHITE
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            } else {
                tvToolbar.setTextColor(Color.WHITE)
                toolbarMain.setBackgroundColor(getColorFromAttr(R.attr.colorPrimary))
                window.statusBarColor = getColorFromAttr(R.attr.colorPrimary)
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            }
        })
    }
}