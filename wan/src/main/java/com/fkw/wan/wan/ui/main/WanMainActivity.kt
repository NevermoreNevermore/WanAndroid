package com.fkw.wan.wan.ui.main

import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.LogUtils
import com.fkw.wan.common.BaseActivity
import com.fkw.wan.common.RouterActivityPath
import com.fkw.wan.wan.R


/**
 * description:  WanAndroid主界面
 *
 * version:      1.0

 * createTime:   2020/10/12 15:36

 * modifyTime:   2020/10/12 15:36

 * @author       fkw
 */
@Route(path = RouterActivityPath.WAN_MAIN)
class WanMainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.wan_activity_main)
    }


}