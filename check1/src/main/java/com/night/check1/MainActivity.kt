package com.night.check1

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private var pageModels: MutableList<PageModel> = ArrayList()

    init {
        pageModels.add(PageModel(R.layout.view_prase, R.string.title_praise))
        pageModels.add(PageModel(R.layout.view_ruler, R.string.title_ruler))
        pageModels.add(PageModel(R.layout.view_flip, R.string.title_flip))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        //init viewPage
        mViewPage.adapter = object : FragmentPagerAdapter(supportFragmentManager) {

            override fun getItem(position: Int): Fragment {
                val pageModel = pageModels[position]
                return PageFragment.newInstance(pageModel.resId)
            }

            override fun getCount(): Int {
                return pageModels.size
            }

            override fun getPageTitle(position: Int): CharSequence? {
                return getString(pageModels[position].title)
            }
        }

        //inline with tableLayout
        mTabLayout.setupWithViewPager(mViewPage)
    }


    private inner class PageModel internal constructor(
        @param:LayoutRes @field:LayoutRes
        internal var resId: Int,
        @param:StringRes @field:StringRes
        internal var title: Int
    )
}
