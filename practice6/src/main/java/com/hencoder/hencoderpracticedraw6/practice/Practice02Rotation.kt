package com.hencoder.hencoderpracticedraw6.practice

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.practice_rotation.view.*


class Practice02Rotation : RelativeLayout {
    var mNum = 0

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        animateBt.setOnClickListener {
            when (mNum) {
                //rotation(180) -> rotation(0)   back operation
                //rotation(180) -> rotationBy(180)  continue operation

                0 -> imageView.animate().rotation(180f)
                1 -> imageView.animate().rotation(0f)
                2 -> imageView.animate().rotationX(180f)
                3 -> imageView.animate().rotationX(0f)
                4 -> imageView.animate().rotationY(180f)
                5 -> imageView.animate().rotationYBy(180f)
            }

            mNum++
            if (mNum >= 6) mNum = 0
        }
    }
}