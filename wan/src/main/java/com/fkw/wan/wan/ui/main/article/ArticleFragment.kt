package com.fkw.wan.wan.ui.main.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.TimeUtils
import com.blankj.utilcode.util.ToastUtils
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.fkw.wan.common.BaseFragment
import com.fkw.wan.wan.R
import com.fkw.wan.wan.entity.Article
import kotlinx.android.synthetic.main.wan_frag_article.*

/**
 * description:  首页-文章对应的Fragment
 *
 * version:      1.0

 * createTime:   2020/10/13 15:56

 * modifyTime:    2020/10/13 15:56

 * @author       fkw
 */
class ArticleFragment : BaseFragment() {

    private lateinit var mAdapter: BaseQuickAdapter<Article, BaseViewHolder>
    private lateinit var mModel: ArticleViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.wan_frag_article, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initUI()
        mModel = ArticleViewModel()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //mModel = ArticleViewModel(requireActivity().application)
        initData()
    }

    private fun initUI() {
        srl.setOnRefreshListener {
            mModel.initData()
        }

        srl.setOnLoadMoreListener {
            mModel.loadMore()
        }

        // 自动刷新
        srl.autoRefresh()

        mAdapter = object : BaseQuickAdapter<Article, BaseViewHolder>(R.layout.wan_item_article, null) {
            override fun convert(holder: BaseViewHolder, item: Article) {
                holder.setText(R.id.tv_title, item.title)
                holder.setText(R.id.tv_author, "作者：${item.author}")
                holder.setText(R.id.tv_time, TimeUtils.getFriendlyTimeSpanByNow(item.publishTime))
            }

        }
        rv.layoutManager = LinearLayoutManager(view?.context)
        rv.adapter = mAdapter
        mAdapter.setEmptyView(R.layout.wan_layout_empty_list)


        // 跳转到搜索界面
        tv_search.setOnClickListener {
            findNavController().navigate(R.id.wan_action_main_to_search)
        }
    }

    private fun initData() {
        mModel.articleList.observe(viewLifecycleOwner, Observer {
            srl.finishRefresh()
            srl.finishLoadMore()
            if (it == null) {
                mAdapter.setList(mutableListOf())
            } else {
                mAdapter.setList(it)
            }
        })
        mModel.noMoreData.observe(viewLifecycleOwner, Observer {
            if (it) {
                srl.finishLoadMoreWithNoMoreData()
            }
        })
        mModel.errorInfo.observe(viewLifecycleOwner, Observer {
            // 显示不同的界面
            LogUtils.i("$it")
        })

    }

    override fun onResume() {
        super.onResume()

    }

}

