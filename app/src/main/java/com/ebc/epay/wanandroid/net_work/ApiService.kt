package com.ebc.epay.wanandroid.net_work

import com.ebc.epay.wanandroid.entity.Banner
import com.ebc.epay.wanandroid.entity.HttpResult
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.ArrayList

/**
 * Created by ocean on 2019-12-16
 * @describe:
 */
open class ApiService :RetrofitHelper(){

    class ClassLoader{

        companion object{
          val INSTANCE:ApiService= ApiService()
        }
    }

     public fun  getInstance ():ApiService=ClassLoader.INSTANCE
















}