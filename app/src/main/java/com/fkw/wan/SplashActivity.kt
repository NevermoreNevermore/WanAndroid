package com.fkw.wan

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.fkw.wan.common.BaseActivity
import com.fkw.wan.common.RouterActivityPath
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startAnim()
    }

    private fun startAnim() {
        wan_tv_splash.animate().apply {
            setDuration(1500).scaleX(2F).scaleY(2F)
            setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    goMain()
                }
            })
        }

    }

    private fun goMain() {
        ARouter.getInstance().build(RouterActivityPath.WAN_MAIN)
            .navigation()
        finish()
    }

}