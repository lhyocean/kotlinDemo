package com.yuchengnet.android.directbank

import android.app.Activity

/**
 * Created by 田洪龙 on 2017/6/19.
 */
open class TestDemoFather ():Activity() {

    lateinit var name: String

    constructor(name: String):this() {
        this.name = name
    }
}