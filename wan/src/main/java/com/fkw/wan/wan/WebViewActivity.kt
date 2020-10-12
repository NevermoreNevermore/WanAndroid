package com.fkw.wan.wan

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.net.http.SslError
import android.os.Bundle
import android.view.ViewGroup
import android.webkit.*
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.LogUtils
import com.fkw.wan.common.BaseActivity
import kotlinx.android.synthetic.main.wan_layout_fl_container.*


/**
 * description:  文章详细信息的Activity
 *
 * version:      1.0

 * createTime:   2020/9/10 19:45

 * modifyTime:   2020/9/10 19:45

 * @author       fkw
 */
class WebViewActivity : BaseActivity() {


    companion object {

        private const val EXTRA_URL = "extra_url"

        fun start(activity: Activity, url: String) {
            val intent = Intent(activity, WebViewActivity::class.java).apply {
                putExtra(EXTRA_URL, url)
            }
            activity.startActivity(intent)
        }

        fun start(url: String) {
            start(ActivityUtils.getTopActivity(), url)
        }
    }


    private lateinit var mWebView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.wan_layout_fl_container)
        initWebView()
        val extra = intent.getStringExtra(EXTRA_URL)
        mWebView.loadUrl(extra!!)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onResume() {
        super.onResume()
        mWebView.settings.javaScriptEnabled = true
    }

    override fun onStop() {
        super.onStop()
        mWebView.settings.javaScriptEnabled = false
    }

    override fun onDestroy() {
        super.onDestroy()
        (mWebView.parent as ViewGroup).removeView(mWebView)
        mWebView.stopLoading()
        mWebView.settings.javaScriptEnabled = false
        mWebView.clearHistory()
        mWebView.clearAnimation()
        mWebView.clearView()
        mWebView.removeAllViews()
        mWebView.destroy()
    }

    override fun onBackPressed() {
        if (mWebView != null && mWebView.canGoBack()) {
            mWebView.goBack()
        } else {
            super.onBackPressed()
        }
    }

    /**
     * 初始化WebView
     */
    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView() {
        mWebView = WebView(this).apply {
            // 各种参数的设置
            settings.apply {
                // 设置允许JavaScript，默认是false
                javaScriptEnabled = true
                // Js是否可以自动打开窗口
                javaScriptCanOpenWindowsAutomatically = false

                // 不支持多个窗口
                setSupportMultipleWindows(false)
            }
            //
            webViewClient = Client()

            // 如果有下载，就跳到系统浏览器进行下载
            setDownloadListener { url, userAgent, contentDisposition, mimetype, contentLength ->
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    addCategory(Intent.CATEGORY_BROWSABLE)
                    data = Uri.parse(url)
                }
                startActivity(intent)
            }

        }

        fl_container.addView(mWebView, -1, -1)


    }

    inner class Client : WebViewClient() {
        /**
         * 每次加载新的URL之前，都会调用这个方法。
         * 返回false，表示不干预WebView的操作，也就是继续加载，返回true，表示拦截，不加载
         *
         * 因为现在有很多重定向，WebView无法解析，只能解析http协议。
         * 这里做一下拦截，WebView可以解析的Http和Https链接不拦截，其它的都进行拦截
         */
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            val url = request?.url.toString()
            LogUtils.i(url)
            return !(url.startsWith("http:") || url.startsWith("https"))
        }


        override fun onReceivedError(
            view: WebView?,
            request: WebResourceRequest?,
            error: WebResourceError?
        ) {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                LogUtils.i(error?.description)
                LogUtils.i(error?.errorCode)
            }
            super.onReceivedError(view, request, error)
        }

        override fun onReceivedHttpError(
            view: WebView?,
            request: WebResourceRequest?,
            errorResponse: WebResourceResponse?
        ) {
            super.onReceivedHttpError(view, request, errorResponse)
        }

        override fun onReceivedSslError(
            view: WebView?,
            handler: SslErrorHandler?,
            error: SslError?
        ) {
            super.onReceivedSslError(view, handler, error)
        }
    }

}