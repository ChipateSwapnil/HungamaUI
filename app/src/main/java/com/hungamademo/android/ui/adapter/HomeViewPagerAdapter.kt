package com.hungamademo.android.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hungamademo.android.model.TabData
import com.hungamademo.android.ui.view.fragments.CommonViewPagerItemFragment

class HomeViewPagerAdapter(var fragment: Fragment, var tabItemModelItems: ArrayList<TabData>) :
    FragmentStateAdapter(fragment) {

    private val ARG_BOTTOM_NAVIGATION_SELECTED = "bottomNavigationSelected"

    override fun getItemCount(): Int = tabItemModelItems.size


    override fun createFragment(position: Int): Fragment {
        return getFragment(tabItemModelItems[position].title)
    }

    //add the dynamic tabLayout into frame layout on item position
    private fun getFragment(selectedTabName: String): Fragment {
        val bottomNavigationSelected = fragment.arguments?.getString(ARG_BOTTOM_NAVIGATION_SELECTED)
        return bottomNavigationSelected?.let {
            CommonViewPagerItemFragment.newInstance(
                selectedTabName,
                it
            )
        }
            ?: CommonViewPagerItemFragment()
    }
}