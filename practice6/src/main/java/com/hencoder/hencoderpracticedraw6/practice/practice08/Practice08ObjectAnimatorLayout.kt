package com.hencoder.hencoderpracticedraw6.practice.practice08

import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.animation.OvershootInterpolator
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.practice_object_animator.view.*

class Practice08ObjectAnimatorLayout : RelativeLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        animateBt.setOnClickListener {
            //  在这里处理点击事件，用 ObjectAnimator 播放动画
            // 1. 用 ObjectAnimator 创建 Animator 对象
            // 2. 用 start() 执行动画
            // *. 记得在 Practice08ObjectAnimatorView 中为 progress 添加 setter/ getter 方法！
            val animator = ObjectAnimator.ofFloat(objectAnimatorView, "progress", 88f)
            animator.duration = 1500
            animator.interpolator = OvershootInterpolator()
            animator.start()
        }
    }
}
