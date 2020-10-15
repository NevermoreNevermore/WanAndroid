package com.fkw.wan.wan.entity


/**
 * description:  数据库和接口需要用到的实体类
 *
 * version:      1.0

 * createTime:   2020/9/10 16:53

 * modifyTime:   2020/9/10 16:53

 * @author       fkw

 */

/**
 * 返回的数据的根
 */
data class RespRoot<T>(
    val `data`: T,
    val errorCode: Int,
    val errorMsg: String
)

/**
 * 文章列表中每次请求的数据为一页
 */
data class Page<T>(
    /** 当前第几页数据，从1开始算，而不是0 */
    val curPage: Int,
    val datas: ArrayList<T>,
    /** 当前数据第一条开始条数 */
    val offset: Int,
    /** 当前是不是最后一页 */
    val over: Boolean,
    /** 总的页数 */
    val pageCount: Int,
    /** 每页数据 */
    val size: Int,
    /** 总的条数 */
    val total: Int
)


/**
 * 文章标签
 */
data class Tag(
    val name: String,
    val url: String
)


/**
 * 首页Banner对应的数据
 */
data class Banner(
    val desc: String,
    val id: Int,
    val imagePath: String,
    val isVisible: Int,
    val order: Int,
    val title: String,
    val type: Int,
    val url: String
)

/**
 * 热搜词汇
 */
data class HotKey(
    val id: Int,
    val link: String,
    val name: String,
    val order: Int,
    val visible: Int
)