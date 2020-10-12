package com.fkw.wan.wan.entity


/**
 * description:  列表对应的实体类
 *
 * version:      1.0

 * createTime:   2020/9/10 17:12

 * modifyTime:   2020/9/10 17:12

 * @author       fkw
 */
data class Page<T>(
    val curPage: Int,
    val datas: ArrayList<T>,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
)