package com.example.challange40

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class AdapterViewPager(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val dataFragment = mutableListOf<Fragment>().apply {
        add(LandingPageA())
        add(LandingPageB())
        add(LandingPageD())
        add(LandingPageC())
    }


    override fun getItem(position: Int): Fragment {
        return dataFragment[position]
    }

    override fun getCount(): Int {
        return dataFragment.size
    }


}