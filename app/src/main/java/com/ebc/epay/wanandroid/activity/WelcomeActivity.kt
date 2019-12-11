package com.ebc.epay.wanandroid.activity
import android.content.Intent
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import com.ebc.epay.wanandroid.R
import com.ebc.epay.wanandroid.base.BaseActivity
import kotlinx.android.synthetic.main.activity_welcome.*


class WelcomeActivity : BaseActivity() {
    private var animation :AlphaAnimation?=null

    override fun setLayoutResId(): Int = R.layout.activity_welcome

    override fun initData() {

    }
    override fun initView() {

        animation=AlphaAnimation(0.2f,1f)
        animation?.run {
            duration=3000
            setAnimationListener(object :Animation.AnimationListener{
                override fun onAnimationRepeat(p0: Animation?) {

                }

                override fun onAnimationEnd(p0: Animation?) {
                     jumpToMain()
                }

                override fun onAnimationStart(p0: Animation?) {

                }
            })
        }
        cons_l.startAnimation(animation)
    }

    fun jumpToMain() {

        var intent=Intent()
        intent.setClass(this,MainActivity::class.java)
        startActivity(intent)
        finish()
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
    }















}
