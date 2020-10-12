package com.fkw.wan

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter


/**
 * description:  Application
 *
 * version:      1.0

 * createTime:   2020/10/12 15:28

 * modifyTime:   2020/10/12 15:28

 * @author       fkw
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initARouter()
    }

    private fun initARouter() {
        if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }
}