package com.yuchengnet.android.directbank

/**
 * Created by 田洪龙 on 2017/6/20.
 * 此处是接口的写法，与java区别不大
 */
interface TestMessageResponse {

    fun resultBack(json: String) :String
}