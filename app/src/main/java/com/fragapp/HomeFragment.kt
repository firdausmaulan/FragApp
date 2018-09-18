package com.fragapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.home_fragment.view.*

class HomeFragment : Fragment() {

    public fun HomeFragment(){
        // Required empty public constructor
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.home_fragment, container, false)

        setupViewPager(view.viewpager)

        view.tabLayout?.setupWithViewPager(view.viewpager)

        return view
    }

    private fun setupViewPager(viewPager: ViewPager?) {
        val adapter = ViewPagerAdapter(fragmentManager)
        adapter.addFragment(OneFragment(), "ONE")
        adapter.addFragment(TwoFragment(), "TWO")
        adapter.addFragment(ThreeFragment(), "THREE")
        viewPager?.adapter = adapter
    }

    class ViewPagerAdapter(manager: FragmentManager?) : FragmentPagerAdapter(manager) {
        private val mFragmentList = ArrayList<Fragment>()
        private val mFragmentTitleList = ArrayList<String>()

        override fun getItem(position: Int): Fragment {
            return mFragmentList.get(position)
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mFragmentTitleList.get(position)
        }
    }
}