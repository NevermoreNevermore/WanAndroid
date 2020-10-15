package com.fkw.wan.wan.ui.main

import com.fkw.wan.wan.entity.Article
import com.fkw.wan.wan.entity.Page
import com.fkw.wan.wan.entity.RespRoot
import com.fkw.wan.wan.net.server
import com.fkw.wan.wan.ui.list.ListFragment

/**
 * description:  WanAndroid--问答
 *
 * version:      1.0

 * createTime:   2020/10/14 16:24

 * modifyTime:    2020/10/14 16:24

 * @author       fkw
 */
class AnswerFragment : ListFragment() {

    override suspend fun getData(page: Int): RespRoot<Page<Article>> {
        return server.getAnswer(page)
    }
}