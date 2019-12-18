package com.ebc.epay.wanandroid.net_work

import okhttp3.Interceptor
import okhttp3.Response

import java.io.IOException

/**
 * Created by ocean on 2019-12-16
 *
 * @describe:
 */
class HeadInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response? {
        val  request=chain.request()
        val builder=request.newBuilder()
        builder.addHeader("Content-type", "application/json; charset=utf-8")

        return chain.proceed(builder.build())
    }
}
