package com.fkw.wan.wan.entity


/**
 * description:  文章对应的实体类，除了标题和链接，其它都可能为null
 *
 * version:      1.0

 * createTime:   2020/9/10 17:11

 * modifyTime:   2020/9/10 17:11

 * @author       fkw
 */

data class Article(
    val apkLink: String,
    val audit: Int,
    val author: String,
    val canEdit: Boolean,
    val chapterId: Int,
    val chapterName: String,
    val collect: Boolean,
    val courseId: Int,
    val desc: String,
    val descMd: String,
    val envelopePic: String,
    val fresh: Boolean,
    val id: Int,
    val link: String,
    val niceDate: String,
    val niceShareDate: String,
    val origin: String,
    val prefix: String,
    val projectLink: String,
    val publishTime: Long,
    val realSuperChapterId: Int,
    val selfVisible: Int,
    val shareDate: Long,
    val shareUser: String,
    /** 一级分类的第一个子类目的ID */
    val superChapterId: Int,
    /** 一级分类名称 */
    val superChapterName: String,
    val tags: List<Tag>,
    val title: String,
    val type: Int,
    val userId: Int,
    val visible: Int,
    val zan: Int
)
