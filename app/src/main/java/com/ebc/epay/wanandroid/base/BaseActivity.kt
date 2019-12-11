package com.ebc.epay.wanandroid.base

import android.content.Context
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by ocean on 2019-12-05
 * @describe:
 */
abstract class BaseActivity : AppCompatActivity(){

    var context:Context ?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutResId())
        initView()
        initData()

        context=this


    }

    abstract fun initData()

    abstract fun initView()
    @LayoutRes
    protected abstract fun setLayoutResId():Int


}
