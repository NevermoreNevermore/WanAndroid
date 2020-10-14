package com.fkw.wan

import android.R
import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.LogUtils
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.ClassicsHeader
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import com.scwang.smart.refresh.layout.api.RefreshFooter
import com.scwang.smart.refresh.layout.api.RefreshHeader
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.DefaultRefreshFooterCreator
import com.scwang.smart.refresh.layout.listener.DefaultRefreshHeaderCreator


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
        LogUtils.i("time")
        initARouter()

        initOtherModule()
    }

    private fun initARouter() {
        if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }


    private fun initOtherModule() {
        initWanAndroid()
    }

    private fun initWanAndroid() {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, layout -> ClassicsHeader(context) }
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator { context, layout ->
            ClassicsFooter(context).setDrawableSize(20f)
        }
    }


}