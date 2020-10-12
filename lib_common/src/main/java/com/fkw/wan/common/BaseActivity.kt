package com.fkw.wan.common

import android.R
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


/**
 * description:  基类Activity
 *
 * version:      1.0

 * createTime:   2020/10/12 15:08

 * modifyTime:   2020/10/12 15:08

 * @author       fkw
 */
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBar()
    }


    /**
     * 设置状态栏的UI，透明
     */
    private fun setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // 6.0以上设置为白底黑字
            //getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.statusBarColor = Color.WHITE
        } else {
            // 5.0 5.1的状态栏
            window.setBackgroundDrawableResource(R.color.transparent)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            window.statusBarColor = Color.GRAY
        }
    }

}