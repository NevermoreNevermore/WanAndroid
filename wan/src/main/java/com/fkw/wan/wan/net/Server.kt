package com.fkw.wan.wan.net

import com.fkw.wan.base.net.NetClient
import com.fkw.wan.wan.entity.*
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * description:  后台接口
 *
 * version:      1.0

 * createTime:   2020/9/10 16:42

 * modifyTime:   2020/9/10 16:42

 * @author       fkw
 */
interface Server {

    /**
     * 获取文章列表
     * @param index 页码数
     */
    @GET("article/list/{index}/json")
    suspend fun getTopic(@Path("index") index: Int): RespRoot<Page<Article>>

    /**
     * 获取问答列表
     * @param index 页码数
     */
    @GET("wenda/list/{index}/json")
    suspend fun getAnswer(@Path("index") index: Int): RespRoot<Page<Article>>

    /**
     * 获取首页Banner数据
     */
    @GET("banner/json")
    suspend fun getBanner(): RespRoot<List<Banner>>

    /**
     * 获取搜索热词
     */
    @GET("hotkey/json")
    suspend fun getHorKey(): RespRoot<List<HotKey>>

}

val server: Server = NetClient.retrofit.create(Server::class.java)

/** 返回数据成功 */
const val NET_CODE_SUCCESS = 0