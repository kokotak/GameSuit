package com.example.challange40

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_landing_page.*
import kotlinx.android.synthetic.main.fragment_landing_page_c.*

const val PLAYER_NAME = "playName"
const val LANDING_PAGE = "landingPage"

class LandingPage : AppCompatActivity() {

    private lateinit var adapterViewPager: AdapterViewPager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)

        adapterViewPager = AdapterViewPager(supportFragmentManager)
        viewPager.adapter = adapterViewPager
        spring_dots_indicator.setViewPager(viewPager)

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
//                if (position == adapterViewPager.count.minus(1)) {
//                    btn_inputPlayerName.visibility = VISIBLE
//                } else {
//                    btn_inputPlayerName.visibility = GONE
//                }
            }

        })

    }
}
