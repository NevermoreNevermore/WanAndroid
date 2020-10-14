package com.fkw.wan.wan.ui.main

import android.os.Bundle
import android.os.Debug
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.TimeUtils
import com.blankj.utilcode.util.ToastUtils
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.fkw.wan.common.BaseFragment
import com.fkw.wan.wan.R
import com.fkw.wan.wan.base.BaseAdapter
import com.fkw.wan.wan.base.BaseHolder
import com.fkw.wan.wan.entity.Article
import com.fkw.wan.wan.entity.Page
import com.fkw.wan.wan.entity.RespRoot
import com.fkw.wan.wan.net.server
import kotlinx.android.synthetic.main.wan_frag_article.*
import kotlinx.android.synthetic.main.wan_item_article.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * description:  首页-文章对应的Fragment$
 *
 * version:      1.0$

 * createTime:   2020/10/13 15:56

 * modifyTime:    2020/10/13 15:56

 * @author       fkw$
 */
class ArticleFragment : BaseFragment() {

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


        tv_search.setOnClickListener {
            findNavController().navigate(R.id.wan_action_main_to_search)
        }

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

