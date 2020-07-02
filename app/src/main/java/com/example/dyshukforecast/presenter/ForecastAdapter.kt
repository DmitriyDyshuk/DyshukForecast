package com.example.dyshukforecast.presenter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.dyshukforecast.R
import com.example.dyshukforecast.model.Weather

class ForecastAdapter(private val context: Context, private val itemList: ArrayList<Weather>) : PagerAdapter() {

    override fun getCount() = itemList.size

    override fun instantiateItem(view: ViewGroup, position: Int): Any {
        val layout = LayoutInflater.from(context).inflate(R.layout.item_forecast_wearher, view, false)
        val item = itemList[position]

//        layout.rbRating.setScore(item.rating * 2)
//        layout.tvTitle.text = item.title
//        layout.tvDescription.text = item.description
//
//
//        view.addView(layout, 0)

        return layout
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: View, position: Int, `object`: Any) {
        (container as ViewPager).removeView(`object` as View)
    }

    override fun getPageWidth(position: Int): Float {
        return 0.8F
    }
}