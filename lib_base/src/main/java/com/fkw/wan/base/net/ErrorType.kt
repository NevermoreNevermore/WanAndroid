package com.fkw.wan.base.net

/**
 * description:  网络错误类型，三种
 *
 * version:      1.0

 * createTime:   2020/10/15 11:55

 * modifyTime:    2020/10/15 11:55

 * @author       fkw
 */
enum class ErrorType {
    /**
     * 后台返回值异常。说明流程没问题，逻辑有问题。
     */
    ERROR_RESP,

    /**
     * 服务器内部异常。
     */
    ERROR_SERVER,

    /**
     * 网络异常。
     */
    ERROR_NET
}