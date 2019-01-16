package com.hencoder.hencoderpracticedraw6.practice

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.practice_scale.view.*

class Practice03Scale : RelativeLayout {
    var mNum = 0

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        animateBt.setOnClickListener {
            // 在这里处理点击事件，通过 View.animate().scaleX/Y() 来让 View 放缩
            when (mNum) {
                0 -> imageView.animate().scaleX(1.5f)
                1 -> imageView.animate().scaleX(1f)
                2 -> imageView.animate().scaleY(.5f)
                3 -> imageView.animate().scaleY(1f)
            }

            mNum++
            if (mNum >= 4) mNum = 0
        }
    }
}