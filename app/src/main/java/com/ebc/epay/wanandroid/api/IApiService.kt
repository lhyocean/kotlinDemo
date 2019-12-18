package com.ebc.epay.wanandroid.api

import com.ebc.epay.wanandroid.entity.Banner
import com.ebc.epay.wanandroid.entity.HttpResult
import com.ebc.epay.wanandroid.entity.UserInfo
import io.reactivex.Observable
import retrofit2.http.*

/**
 * Created by ocean on 2019-12-13
 * @describe:
 */
interface IApiService {


    /**
     * 登录
     * http://www.wanandroid.com/user/login
     *
     *
     *
     */
    @POST("user/login")
    @FormUrlEncoded
    fun userLogin(@Field("username") username:String,
                  @Field("password") password:String):Observable<HttpResult<UserInfo>>

    @GET("banner/json")
    fun getBanners():Observable<HttpResult<ArrayList<Banner>>>








}