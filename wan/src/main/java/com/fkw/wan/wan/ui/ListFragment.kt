package com.fkw.wan.wan.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.TimeUtils
import com.blankj.utilcode.util.ToastUtils
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.fkw.wan.common.BaseFragment
import com.fkw.wan.wan.R
import com.fkw.wan.wan.base.BaseWanFragment
import com.fkw.wan.wan.entity.Article
import com.fkw.wan.wan.entity.Page
import com.fkw.wan.wan.entity.RespRoot
import com.fkw.wan.wan.net.server
import kotlinx.android.synthetic.main.wan_frag_article.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * description:  显示数据列表的Fragment的基类
 *
 * version:      1.0

 * createTime:   2020/10/13 15:58

 * modifyTime:    2020/10/13 15:58

 * @author       fkw
 */
open class ListFragment : BaseWanFragment() {


    private lateinit var mAdapter: BaseQuickAdapter<Article, BaseViewHolder>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.wan_frag_article, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initUI()
        getData()
    }

    private fun initUI() {
        srl.setOnRefreshListener {
            ToastUtils.showShort("refresh")
            it.finishRefresh(1500)
        }

        srl.setOnLoadMoreListener {
            ToastUtils.showShort("load more")
            it.finishLoadMore(1500)
        }


        mAdapter = object : BaseQuickAdapter<Article, BaseViewHolder>(R.layout.wan_item_article, null) {
            override fun convert(holder: BaseViewHolder, item: Article) {
                holder.setText(R.id.tv_title, item.title)
                holder.setText(R.id.tv_author, "作者：${item.author}")
                holder.setText(R.id.tv_time, TimeUtils.getFriendlyTimeSpanByNow(item.publishTime))
            }

        }
        rv.adapter = mAdapter
        rv.layoutManager = LinearLayoutManager(view?.context)




    }

    private fun getData() {
        GlobalScope.launch(Dispatchers.Main) {
            val data = getData(0)
            LogUtils.i(data)
            mAdapter.setNewInstance(data.data.datas)
        }
    }

    protected open suspend fun getData(page: Int): RespRoot<Page<Article>> {
        return server.getTopic(page)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }


}