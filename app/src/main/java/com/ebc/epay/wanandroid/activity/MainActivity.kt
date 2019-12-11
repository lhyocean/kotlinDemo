package com.ebc.epay.wanandroid.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.FragmentTransaction
import com.ebc.epay.wanandroid.R
import com.ebc.epay.wanandroid.base.BaseActivity
import com.ebc.epay.wanandroid.constant.Constant
import com.ebc.epay.wanandroid.fragment.FindFragment
import com.ebc.epay.wanandroid.fragment.HomeFragment
import com.ebc.epay.wanandroid.fragment.HotFragment
import com.ebc.epay.wanandroid.fragment.MineFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : BaseActivity() {

    private var mIndex: Int = 0
    private val KEY_INDEX: String = "key_bottom_index"
    private var homeFragment: HomeFragment? = null
    private var findFragment: FindFragment? = null
    private var hotFragment: HotFragment? = null
    private var mineFragment: MineFragment? = null

    override fun initData() {}
    override fun setLayoutResId(): Int = R.layout.activity_main
    override fun initView() {

        toolbar.run {
            title = getString(R.string.app_name)
            setSupportActionBar(this)
        }

        bottom_nav_view.run {
            labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED
            setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
            itemIconTintList=null
        }
        showFragment(mIndex)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            mIndex = savedInstanceState.getInt(KEY_INDEX, 0)
        }
        super.onCreate(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_INDEX, mIndex)
    }


    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
            menuItem ->
        return@OnNavigationItemSelectedListener when (menuItem.itemId) {
            R.id.menu_home -> {

                showFragment(0)
                true
            }

            R.id.menu_find -> {

                showFragment(1)
                true
            }
            R.id.menu_hot -> {

                showFragment(2)
                true
            }
            R.id.menu_mine -> {

                showFragment(3)
                true
            }

            else -> false
        }
    }

    private fun showFragment(i: Int) {

        var transaction = supportFragmentManager.beginTransaction()
        hideAllFragment(transaction)
        when (i) {
            0 -> {
                toolbar.title = getString(R.string.menu_home)
                if (homeFragment==null){
                    var bundle = Bundle()
                    bundle.putString(Constant.KEY_TITLE,getString(R.string.menu_home))
                    homeFragment= HomeFragment.getInstance(bundle)
                    transaction.add(R.id.container,homeFragment!!,getString(R.string.menu_home))
                }else
                    transaction.show(homeFragment!!)
            }
            1 -> {
                toolbar.title = getString(R.string.menu_find)
                if (findFragment==null){
                    var bundle = Bundle()
                    bundle.putString(Constant.KEY_TITLE,getString(R.string.menu_find))
                    findFragment= FindFragment.getInstance(bundle)
                    transaction.add(R.id.container,findFragment!!,getString(R.string.menu_find))
                }else
                    transaction.show(findFragment!!)
            }
            2 -> {
                toolbar.title = getString(R.string.menu_hot)

                if (hotFragment==null){
                    var bundle = Bundle()
                    bundle.putString(Constant.KEY_TITLE,getString(R.string.menu_hot))
                    hotFragment= HotFragment.getInstance(bundle)
                    transaction.add(R.id.container,hotFragment!!,getString(R.string.menu_hot))
                }else
                    transaction.show(hotFragment!!)
            }
            3 -> {
                toolbar.title = getString(R.string.menu_mine)

                if (mineFragment==null){
                    var bundle = Bundle()
                    bundle.putString(Constant.KEY_TITLE,getString(R.string.menu_mine))
                    mineFragment= MineFragment.getInstance(bundle)
                    transaction.add(R.id.container,mineFragment!!,getString(R.string.menu_mine))
                }else
                    transaction.show(mineFragment!!)
            }
        }
        transaction.commit()
    }

    private fun hideAllFragment(transaction: FragmentTransaction) {

        homeFragment?.let { transaction.hide(it) }
        hotFragment?.let { transaction.hide(it) }
        findFragment?.let { transaction.hide(it) }
        mineFragment?.let { transaction.hide(it) }

    }

}
