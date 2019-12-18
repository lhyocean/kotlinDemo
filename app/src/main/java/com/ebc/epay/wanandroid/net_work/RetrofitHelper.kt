package com.ebc.epay.wanandroid.net_work

import com.ebc.epay.wanandroid.BuildConfig
import com.ebc.epay.wanandroid.api.IApiService
import com.ebc.epay.wanandroid.constant.Constant
import com.ebc.epay.wanandroid.entity.HttpResult
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by ocean on 2019-12-13
 * @describe:
 */
open class RetrofitHelper {

    private var retrofit: Retrofit? = null

    var service: IApiService = getRetrofit()!!.create(IApiService::class.java)

    private fun getRetrofit(): Retrofit? {
        if (retrofit == null) {
            synchronized(RetrofitHelper::class.java) {
                if (retrofit == null)
                    retrofit = Retrofit.Builder()
                        .baseUrl(Constant.BASE_URL)
                        .client(getOkHttpClient())
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build()
            }
        }
        return retrofit
    }

    private fun getOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient().newBuilder()
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG)
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        else httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        builder.run {
            addInterceptor(httpLoggingInterceptor)
            addInterceptor(HeadInterceptor())
            connectTimeout(20, TimeUnit.SECONDS)
            readTimeout(20, TimeUnit.SECONDS)
            writeTimeout(20, TimeUnit.SECONDS)
        }
        return builder.build()
    }

}




