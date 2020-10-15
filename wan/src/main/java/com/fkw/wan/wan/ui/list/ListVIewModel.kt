package com.fkw.wan.wan.ui.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.blankj.utilcode.util.LogUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * description:
 *
 * version:      1.0

 * createTime:   2020/10/14 18:23

 * modifyTime:    2020/10/14 18:23

 * @author       fkw
 */
class ListVIewModel<T>(app: Application) : AndroidViewModel(app) {


    fun getData(page: Int) {
        GlobalScope.launch(Dispatchers.Main) {
            val data = getData(0)
            LogUtils.i(data)
        }
    }
}