package com.hencoder.hencoderpracticedraw6.practice

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.practice_alpha.view.*

class Practice04Alpha : RelativeLayout {
    var mNum = 0

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        animateBt.setOnClickListener {
            //  在这里处理点击事件，通过 View.animate().alpha() 来改变 View 的透明度
            when (mNum) {
                0 -> imageView.animate().alpha(0f)
                1 -> imageView.animate().alpha(1f)
            }

            mNum++
            if (mNum >= 2) mNum = 0
        }
    }
}