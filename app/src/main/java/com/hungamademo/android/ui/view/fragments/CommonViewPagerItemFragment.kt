package com.hungamademo.android.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hungamademo.android.databinding.FragmentMainBinding
import com.hungamademo.android.model.Bucket
import com.hungamademo.android.model.BucketData
import com.hungamademo.android.ui.adapter.BucketAdapter
import com.hungamademo.android.utils.JsonReaderUtils
import com.hungamademo.android.utils.LogUtils

private const val ARG_TAB_SELECTED = "tabSelected"
private const val ARG_BOTTOM_NAVIGATION_SELECTED = "bottomNavigationSelected"

private const val BOTTOM_ITEM_DISCOVER = "Discover"
private const val BOTTOM_ITEM_MUSIC = "Music"
private const val BOTTOM_ITEM_VIDEO = "Video"
private const val BOTTOM_ITEM_NEWS = "News"
private const val BOTTOM_ITEM_LIBRARY = "Library"

class CommonViewPagerItemFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var tabSelected: String? = null
    private var bottomNavigationSelected: String? = null
    private val fragmentBinding get() = binding!!
    private lateinit var bucketAdapter: BucketAdapter
    private lateinit var buckets: Bucket
    private lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            tabSelected = it.getString(ARG_TAB_SELECTED)
            bottomNavigationSelected = it.getString(ARG_BOTTOM_NAVIGATION_SELECTED)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        if (bottomNavigationSelected.equals(BOTTOM_ITEM_DISCOVER) && tabSelected.equals("All")) {
            buckets = getBuckets();
            bucketAdapter =
                BucketAdapter(buckets.dataList as ArrayList<BucketData>, requireContext())


            //set the RecyclerView for Buckets
            binding.rvBuckets.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            binding.rvBuckets.adapter = bucketAdapter

            binding.tvTitle.visibility = View.GONE
        } else {
            val displaytext = "$bottomNavigationSelected : $tabSelected"
            binding.tvTitle.text = displaytext
            binding.tvTitle.visibility = View.VISIBLE
        }
    }

    private fun getBuckets(): Bucket {
        val jsonFileString = JsonReaderUtils.getJsonDataFromAsset(requireContext(), "discover.json")
        LogUtils.LOGI("data", jsonFileString)
        val gson = Gson()
        val bucketModelType = object : TypeToken<Bucket>() {}.type
        return gson.fromJson(jsonFileString, bucketModelType)
    }


    companion object {
        // TODO: Rename and change types and number of parametersd
        @JvmStatic
        fun newInstance(tabSelected: String, bottomNavigationSelected: String) =
            CommonViewPagerItemFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TAB_SELECTED, tabSelected)
                    putString(ARG_BOTTOM_NAVIGATION_SELECTED, bottomNavigationSelected)
                }
            }
    }
}