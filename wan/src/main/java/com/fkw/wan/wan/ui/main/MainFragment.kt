package com.fkw.wan.wan.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.fkw.wan.common.BaseFragment
import com.fkw.wan.wan.R
import kotlinx.android.synthetic.main.wan_frag_main.*


/**
 * description:  主界面也使用Fragment
 *
 * version:      1.0

 * createTime:   2020/10/12 18:07

 * modifyTime:   2020/10/12 18:07

 * @author       fkw
 */
class MainFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.wan_frag_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = Adapter(this)
        vp2.adapter = adapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}

class Adapter(frag: Fragment) : FragmentStateAdapter(frag) {

    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return EmptyFragment(position)
    }

}