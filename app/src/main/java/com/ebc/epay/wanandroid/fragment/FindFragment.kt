package com.ebc.epay.wanandroid.fragment

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ebc.epay.wanandroid.R
import com.ebc.epay.wanandroid.base.BaseFragment
import com.ebc.epay.wanandroid.constant.Constant
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by ocean on 2019-12-09
 * @describe:
 */
class FindFragment :BaseFragment(){
    override fun initView(v: View) {

        this.arguments?.run {
            var text=getString(Constant.KEY_TITLE)
            if (!TextUtils.isEmpty(text))
                tv_show.text=text
        }
    }

    override fun attachLayoutRes(): Int = R.layout.fragment_home

    companion object{
        fun getInstance(bundle: Bundle):FindFragment{
            var fragment=FindFragment()
            fragment.arguments=bundle
            return fragment
        }
    }








}