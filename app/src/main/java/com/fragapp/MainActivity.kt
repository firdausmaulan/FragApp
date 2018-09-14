package com.fragapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.Menu
import android.view.MenuItem


class MainActivity : AppCompatActivity() {

    lateinit var fm: FragmentManager

    val TAG_HOME = "home"
    val TAG_DETAIL = "detail"
    var lastTag: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(HomeFragment(), TAG_HOME)
    }

    fun openDetail() {
        loadFragment(DetailFragment(), TAG_DETAIL)
    }

    private fun loadFragment(fragment: Fragment, tag: String) {
        // create a FragmentManager
        fm = supportFragmentManager
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        val fragmentTransaction = fm.beginTransaction()
        // replace the FrameLayout with new Fragment
        fragmentTransaction.add(R.id.frameLayout, fragment, tag)
        lastTag?.let { fragmentTransaction.addToBackStack(it) }
        fragmentTransaction.commit() // save the changes
        lastTag = tag
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_close, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_close -> {
                onBackPressed()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        if (fm.backStackEntryCount == 0) {
            super.onBackPressed()
        } else {
            fm.popBackStack()
        }
    }
}