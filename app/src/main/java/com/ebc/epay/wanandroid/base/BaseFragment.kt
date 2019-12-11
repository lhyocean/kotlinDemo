package com.ebc.epay.wanandroid.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import java.lang.Exception



/**
 * Created by ocean on 2019-12-09
 * @describe:
 */
 open abstract  class BaseFragment : Fragment (){

    override fun onDetach() {
        super.onDetach()
        try {
            var d=Fragment::class.java.getDeclaredField("mChildFragmentManager")
            d.isAccessible=true
            d.set(this,null)
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    /**
     *    初始化布局
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(attachLayoutRes(),null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
    }
    abstract fun attachLayoutRes(): Int
    abstract fun initView(v:View)

}