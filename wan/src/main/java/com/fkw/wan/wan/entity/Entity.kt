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


data class Tag(
    val name: String,
    val url: String
)