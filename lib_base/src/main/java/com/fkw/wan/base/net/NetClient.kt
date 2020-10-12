package com.fkw.wan.base.net

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * description:  网络相关唯一入口
 *
 * version:      1.0

 * createTime:   2020/9/10 16:34

 * modifyTime:   2020/9/10 16:34

 * @author       fkw
 */
object NetClient {

    val okHttpClient = OkHttpClient.Builder()
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}