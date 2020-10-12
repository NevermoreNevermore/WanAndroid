package com.fkw.wan.wan.net

import androidx.lifecycle.LiveData
import com.fkw.wan.base.net.NetClient
import com.fkw.wan.wan.entity.Article
import com.fkw.wan.wan.entity.Page
import com.fkw.wan.wan.entity.RespRoot
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

}

val server = NetClient.retrofit.create(Server::class.java)