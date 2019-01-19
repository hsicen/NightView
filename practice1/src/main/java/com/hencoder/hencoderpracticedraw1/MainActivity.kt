package com.hencoder.hencoderpracticedraw1

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import java.util.*

/**
 * <p>作者：Night  2019/1/7 22:59
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：HenCoder 绘制基础
 */
class MainActivity : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var pager: ViewPager
    private var pageModels: MutableList<PageModel> = ArrayList()

    init {
        pageModels.add(PageModel(R.layout.sample_color, R.string.title_draw_color, R.layout.practice_color))
        pageModels.add(PageModel(R.layout.sample_circle, R.string.title_draw_circle, R.layout.practice_circle))
        pageModels.add(PageModel(R.layout.sample_rect, R.string.title_draw_rect, R.layout.practice_rect))
        pageModels.add(PageModel(R.layout.sample_point, R.string.title_draw_point, R.layout.practice_point))
        pageModels.add(PageModel(R.layout.sample_oval, R.string.title_draw_oval, R.layout.practice_oval))
        pageModels.add(PageModel(R.layout.sample_line, R.string.title_draw_line, R.layout.practice_line))
        pageModels.add(
            PageModel(
                R.layout.sample_round_rect,
                R.string.title_draw_round_rect,
                R.layout.practice_round_rect
            )
        )
        pageModels.add(PageModel(R.layout.sample_arc, R.string.title_draw_arc, R.layout.practice_arc))
        pageModels.add(PageModel(R.layout.sample_path, R.string.title_draw_path, R.layout.practice_path))
        pageModels.add(PageModel(R.layout.sample_histogram, R.string.title_draw_histogram, R.layout.practice_histogram))
        pageModels.add(PageModel(R.layout.sample_pie_chart, R.string.title_draw_pie_chart, R.layout.practice_pie_chart))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pager = findViewById(R.id.pager)
        pager.adapter = object : FragmentPagerAdapter(supportFragmentManager) {

            override fun getItem(position: Int): Fragment {
                val pageModel = pageModels[position]
                return PageFragment.newInstance(pageModel.sampleLayoutRes, pageModel.practiceLayoutRes)
            }

            override fun getCount(): Int {
                return pageModels.size
            }

            override fun getPageTitle(position: Int): CharSequence? {
                return getString(pageModels[position].titleRes)
            }
        }

        tabLayout = findViewById(R.id.tabLayout)
        tabLayout.setupWithViewPager(pager)
    }

    private inner class PageModel internal constructor(
        @param:LayoutRes @field:LayoutRes
        internal var sampleLayoutRes:
        Int, @param:StringRes @field:StringRes
        internal var titleRes: Int,
        @param:LayoutRes @field:LayoutRes
        internal var practiceLayoutRes: Int
    )
}
