package com.fkw.wan.base.net

/**
 * description:  网络错误信息
 *
 * version:      1.0

 * createTime:   2020/10/15 11:58

 * modifyTime:    2020/10/15 11:58

 * @author       fkw
 */
data class NetErrorInfo(
    /**
     * 错误类型，详细信息看[ErrorType]
     */
    val type: ErrorType,
    /**
     * 错误码
     */
    val code: Int,
    /**
     * 错误信息
     */
    val msg: String,
)