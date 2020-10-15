package com.fkw.wan.wan.ui.main.article

import androidx.lifecycle.*
import com.fkw.wan.base.net.ErrorType
import com.fkw.wan.base.net.NetErrorInfo
import com.fkw.wan.wan.entity.Article
import com.fkw.wan.wan.entity.Page
import com.fkw.wan.wan.entity.RespRoot
import com.fkw.wan.wan.net.NET_CODE_SUCCESS
import com.fkw.wan.wan.net.server
import kotlinx.coroutines.*
import kotlin.Exception

/**
 * description:  Article的ViewModel
 *
 * version:      1.0

 * createTime:   2020/10/14 19:45

 * modifyTime:    2020/10/14 19:45

 * @author       fkw
 */
open class ArticleViewModel() : ViewModel() {

    // 内部维护的信息。但是是一个特殊的错误LiveData
    // 当读取error信息之后自动清空其中的信息,防止下一个观察者读取到之前的错误信息
    private val _errorLiveData = MutableLiveData<NetErrorInfo>()

    // 对外暴露的，不可变量，不允许其它地方修改
    val errorInfo: LiveData<NetErrorInfo>
        get() = _errorLiveData


    /**viewModelScope是一个绑定到当前viewModel的作用域  当ViewModel被清除时会自动取消该作用域，所以不用担心内存泄漏为问题*/
    protected open fun execute(action: suspend CoroutineScope.() -> Unit) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            val resp = action()
        }
    }


    val articleList = MutableLiveData<MutableList<Article>>()
    val noMoreData = MutableLiveData<Boolean>()

    private var mPage = 0

    fun initData() {
        mPage = 0
        getDataFromServer()
    }


    fun loadMore() {
        mPage++
        getDataFromServer()
    }


    private fun getDataFromServer() {
        execute {
            try {
                withContext(Dispatchers.IO) {
                    // 具体的获取数据的方法。
                    val resp = server.getTopic(mPage)
                    // 检测数据是否正常
                    if (checkResp(resp)) {
                        if (mPage == 0) {
                            setData(resp.data.datas)
                        } else {
                            addData(resp.data.datas)
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                // 出了错误，就有错误的UI处理
                _errorLiveData.postValue(NetErrorInfo(ErrorType.ERROR_NET, 400, ""))
            }
        }
    }

    /**
     * 检测返回的数据。
     * 数据是否结束
     */
    private fun checkResp(resp: RespRoot<Page<Article>>): Boolean {

        if (resp.errorCode == NET_CODE_SUCCESS) {
            // 数据正常
            // 1. 看有没有结束
            noMoreData.postValue(resp.data.over)
            return true
        }

        _errorLiveData.postValue(NetErrorInfo(ErrorType.ERROR_SERVER, resp.errorCode, resp.errorMsg))
        return false

    }

    private fun setData(list: MutableList<Article>) {
        articleList.postValue(list)
    }

    private fun addData(list: MutableList<Article>) {
        if (articleList.value == null) {
            setData(list)
        } else {
            articleList.value!!.addAll(list)
            articleList.postValue(articleList.value)
        }
    }


}