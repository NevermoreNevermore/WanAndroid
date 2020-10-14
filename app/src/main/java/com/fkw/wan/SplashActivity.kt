package com.fkw.wan

import android.os.Bundle
import android.os.Debug
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.LogUtils
import com.fkw.wan.common.BaseActivity
import com.fkw.wan.common.RouterActivityPath

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        ARouter.getInstance().build(RouterActivityPath.WAN_MAIN)
            .navigation()
        finish()
    }

}