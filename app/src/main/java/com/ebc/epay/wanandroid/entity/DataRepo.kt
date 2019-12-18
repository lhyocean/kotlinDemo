package com.ebc.epay.wanandroid.entity

/**
 * Created by ocean on 2019-12-13
 * @describe:
 */


data class HttpResult<T>(var data: T) : BaseBean()

// 用户信息
data class UserInfo(
    val username: String,
    val rank: Int,
    val coinCount: Int,
    val userId: Int
)


// 登录数据
data class LoginData(
    val chapterTops: MutableList<String>,
    val collectIds: MutableList<String>,
    val email: String,
    val icon: String,
    val id: Int,
    val password: String,
    val token: String,
    val type: Int,
    val username: String
)


/**
 * {
"desc": "享学~",
"id": 29,
"imagePath": "https://www.wanandroid.com/blogimgs/51616c39-dd11-4173-857c-ec317b8ad9a0.png",
"isVisible": 1,
"order": 0,
"title": "BUG如风，常伴吾身！",
"type": 0,
"url": "https://mp.weixin.qq.com/s/j804G2-76YMqOVUBLRwwoA"
}
 */
data class Banner(
    val title: String,
    val imagePath: String,
    val url: String,
    val type: Int,
    val order: Int,
    val isVisible: Int,
    val id: Int
)

