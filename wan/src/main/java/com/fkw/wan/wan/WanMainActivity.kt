package com.fkw.wan.wan

import android.os.Bundle
import android.os.PersistableBundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.fkw.wan.common.BaseActivity
import com.fkw.wan.common.RouterActivityPath


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