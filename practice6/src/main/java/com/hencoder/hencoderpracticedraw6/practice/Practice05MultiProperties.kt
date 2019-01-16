package com.hencoder.hencoderpracticedraw6.practice

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import com.hencoder.hencoderpracticedraw6.Utils
import kotlinx.android.synthetic.main.practice_multi_properties.view.*

class Practice05MultiProperties : ConstraintLayout {
    var isAnimate = true

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        imageView.scaleX = 0f
        imageView.scaleY = 0f
        imageView.alpha = 0f
        animateBt.setOnClickListener {
            // 在这里处理点击事件，同时对多个属性做动画
            if (isAnimate) {
                imageView.animate()
                    .translationX(Utils.dpToPixel(200f))
                    .rotation(360f)
                    .scaleX(1f)
                    .scaleY(1f)
                    .alpha(1f)
            } else {
                imageView.animate()
                    .translationX(0f)
                    .rotation(0f)
                    .scaleX(0f)
                    .scaleY(0f)
                    .alpha(0f)
            }

            isAnimate = !isAnimate
        }
    }
}
