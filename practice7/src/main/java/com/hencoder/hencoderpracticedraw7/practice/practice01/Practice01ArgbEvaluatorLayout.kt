package com.hencoder.hencoderpracticedraw7.practice.practice01

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.animation.LinearInterpolator
import android.widget.RelativeLayout

import kotlinx.android.synthetic.main.practice_argb_evaluator.view.*

/**
 * <p>作者：Night  2019/1/16 14:04
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：diy color evaluator
 *
 *
 * the use of TypeEvaluator
 */
class Practice01ArgbEvaluatorLayout : RelativeLayout {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        animateBt.setOnClickListener {
            val animator = ObjectAnimator.ofInt(
                objectAnimatorView,
                "color", -0x10000, -0xff0100
            )
            // 在这里使用 ObjectAnimator.setEvaluator() 来设置 ArgbEvaluator，修复闪烁问题
            animator.setEvaluator(ArgbEvaluator())
            animator.interpolator = LinearInterpolator()
            animator.duration = 2000
            animator.start()
        }
    }
}