package com.fkw.wan.wan.ui.main

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import com.fkw.wan.common.BaseFragment
import com.fkw.wan.wan.R
import kotlinx.android.synthetic.main.wan_layout_fl_container.*


/**
 * description:  kn
 *
 * version:

 * createTime:   2020/10/12 18:46

 * modifyTime:   2020/10/12 18:46

 * @author
 */
class EmptyFragment(val position: Int) : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.wan_layout_fl_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val tv = TextView(activity!!).apply {
            text = "EmptyFragment    $position"
        }
        val lp = FrameLayout.LayoutParams(-2, -2)
        lp.gravity = Gravity.CENTER
        fl_container.addView(tv, lp)
    }
}