package com.hungamademo.android.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.hungamademo.android.databinding.FragmentBottomNavigationItemBinding
import com.hungamademo.android.model.TabData
import com.hungamademo.android.ui.adapter.HomeViewPagerAdapter
import com.hungamademo.android.ui.viewmodel.HomeViewModel

private const val ARG_BOTTOM_NAVIGATION_SELECTED = "bottomNavigationSelected"

class HomeFragment : Fragment() {

    //binding items
    private var binding: FragmentBottomNavigationItemBinding? = null
    private var tabItems: ArrayList<TabData> = arrayListOf()

    //viewPager
    private lateinit var homeViewPagerAdapter: HomeViewPagerAdapter
    private var bottomNavigationSelected: String = ""

    // This property is only valid between onCreateView and onDestroyView
    private val fragmentBinding get() = binding!!
    private var homeViewModel: HomeViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            bottomNavigationSelected = it.getString(ARG_BOTTOM_NAVIGATION_SELECTED).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBottomNavigationItemBinding.inflate(inflater, container, false)
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        bottomNavigationSelected?.let { requireContext()?.let { it1 -> ToastUtil.showShortToast(it1, it) } }
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        setViewPager()
    }

    private fun setViewPager() {
        //set viewpager items
        homeViewModel?.getTabItems(bottomNavigationSelected, requireContext())
            ?.observe(this, Observer {
                tabItems = it.dataList as ArrayList<TabData>
                homeViewPagerAdapter = HomeViewPagerAdapter(this, tabItems)
                binding?.pager?.adapter = homeViewPagerAdapter
                binding?.pager?.isUserInputEnabled = false

                //add viewpager to tab layout
                binding?.tabLayout?.let {
                    binding?.pager?.let { it1 ->
                        TabLayoutMediator(it, it1) { tab, position ->
                            tab.text = tabItems[position].title
                        }.attach()
                    }
                }

                //condition to show scroll for tab layout
                if (binding?.tabLayout!!.tabCount == 2) {
                    binding!!.tabLayout.tabMode = TabLayout.MODE_FIXED
                } else {
                    binding!!.tabLayout.tabMode = TabLayout.MODE_SCROLLABLE
                }

            })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(bottomNavigationSelected: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_BOTTOM_NAVIGATION_SELECTED, bottomNavigationSelected)
                }
            }
    }
}