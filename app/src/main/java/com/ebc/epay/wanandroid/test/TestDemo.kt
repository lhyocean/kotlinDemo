package com.yuchengnet.android.directbank

import android.content.Intent
import android.os.Build
import java.util.*
import kotlin.collections.HashMap

/**
 * Created by 田洪龙 on 2017/6/19.
 */
//1、类名后面加open表示该类可以被继承，没有open则不能被继承
//2、类名后面的括号中是主构造方法，住构造方法中的变量可以当成全局变量使用
//3、继承父类的时候需要冒号加父类，父类后面跟的括号是构造函数的意思
//   想要activity后面不带括号，重写父类的构造函数就可以了
class TestDemo() : TestDemoFather(), TestMessageResponse {

    //变量需要实例化，如果不想实例化，可以在var前面加lateinit
    //声明的变量，自动产生get/set方法，不需要自己手写
    var age: String = ""
    var age2: String? = null
    var age3: String = null!!
    var age4: String = null.toString()
    lateinit var age5: String

    //val 声明的变量不可改变
    val year: String = ""
    //其中Int和Boolean类型的变量不能用lateinit，必须初始实例化
    var number: Int = 0
    //创建变量的时候，直接实例化可不用声明类型
    var tName = ""
    //list的创建
    var arrayList = ArrayList<String>()
    lateinit var arrayList2: MutableList<String>
    var arrayList3: MutableList<String> = LinkedList()
    var map: Map<String,String> = HashMap()
    //数组的创建和使用
    val arr: Array<Int> = arrayOf(1, 2, 3)
    val intArr = intArrayOf(1, 2, 3)    //同理还有 booleanArrayOf() 等
    val empty: Array<String> = emptyArray<String>()       //空数组
    var screens: Array<Int?> = arrayOfNulls<Int>(5)        // 数字类型的数组

//    constructor() {
//       //因为父类中含有空参的构造函数，所以此处类名和父类后面都带个括号，如果想去掉括号，那么
//       //去掉此处的注释即可，上面的俩括号就相当于重写了构造函数，如果此处重写空参构造，那么就可以去掉括号
//    }

    //此处的this() 是指的是调用的主构造函数，kotlin的子构造函数必须最后直接或者间接调用的主构造函数，否则报错
    constructor(nickName: String, age: String) : this() {
        //此处是子构造函数
        arrayList2 = ArrayList<String>()
    }

    fun forTest() {
            for(i in arr.indices) {
                if(i ==10)
                    break
                if(i==100)
                    return
            print(arr[i])
        }
        // 左闭右开区间，合法值包括11，但不包括66
        for (i in 11 until 66) {  }
// 每次默认递增1，这里改为每次递增4
        for (i in 23..89 step 4) {  }
// for循环默认递增，这里使用downTo表示递减
        for (i in 50 downTo 7) {  }
    }

    //方法中返回值在后面,返回值后面加个？表是返回值可以是null
    fun testFun(name: String): String? {
        //name += "32"//此处报错，在kotlin中的参数值不可被更改
        return null
    }
    //方法中返回值在后面,返回值后面加个？表是返回值可以是null
    //如果参数被允许为Null ， 但是返回值不允许为null，返回值name可能为null，那么需要后面加!!，检查是否为空
    fun testFun2(name: String?): String {
        return name!!
    }

    //等号相当于return,等号后面的就是返回值，3 * a 就是计算公式，简单写法
    fun testAddEasy(a: Int) = 3 * a

    //无返回值
    fun testAddEasy(a: String): Unit {

    }

    //此处是testAddEasy的正常写法，要复杂不少
    fun testAddNormal(a: Int): Int {
        return 3 * a
    }

    //是继承过来的方法，必须加override
    override fun resultBack(json: String): String {
        return ""
}

    //java中直接new 接口的写法，在kotlin这样，前面加个object : 接口名 {  接口的方法，如下例子 }
    //回调的写法与java相同
    fun useInterface() {
        object : TestMessageResponse {
            override fun resultBack(json: String): String {
                //此处this后面必须加@+activity类名
                val intent = Intent(this@TestDemo, TestKotlinActivity::class.java)
                startActivity(intent)
                return "success"
            }
        }
    }

    // 跳转其他activity,this后面的@+类名可以不写，但是在创建的接口中，必须写，因为this不明当前指明的
    // 类是那个
    fun goOtherActivity() {
        //val intent = Intent(this, TestKotlinActivity::class.java)
        val intent = Intent(this@TestDemo, TestKotlinActivity::class.java)
        startActivity(intent)
    }

    //java中静态方法、静态变量的用法
    fun useStatic() {
        //类名后面加点加方法，和java中一样
        var resultString = TestDemo.getStaticString(TestDemo.staticName)
        //var resultString = getStaticString(staticName)
    }

    /**
     * companion object 就是java中静态的意思，里面的变量是静态变量，里面的方法是静态方法
     * 调用的时候就可以类名 + 点 + 变量/方法
     */
    companion object {

        var staticName = "张景富"

        fun getStatic() {

        }

        fun getStaticString(string: String): String {
            return string+ "==结果"
        }
    }

    //类型转化,可在后面加as 类型
    //或者直接在后面.toInt()或者toString()也就转化了
    fun changeType(age: Int): String {
        var newAge = age as String
        var childAge = newAge as Int
        var ageTwo = newAge.toInt()
        return age.toString()
    }

    inner class TestIn {//inner内部类加入inner关键字，才可以访问外部类的
        fun main() {
            number = 324;
        }
    }

}