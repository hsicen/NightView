package com.hencoder.hencoderpracticedraw7.practice

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.sample_animator_set.view.*

/**
 * <p>作者：Night  2019/1/16 15:26
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：the use of AnimatorSet
 *
 *
 *
 */
class Practice05AnimatorSetLayout : RelativeLayout {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        animateBt.setOnClickListener {
            objectAnimatorView.translationX = -200f

            val animator1 = ObjectAnimator.ofFloat(objectAnimatorView, "alpha", 0f, 1f)
            val animator2 = ObjectAnimator.ofFloat(objectAnimatorView, "translationX", -200f, 200f)
            val animator3 = ObjectAnimator.ofFloat(objectAnimatorView, "rotation", 0f, 1080f)
            animator3.duration = 1000

            val animatorSet = AnimatorSet()
            // 用 AnimatorSet 的方法来让三个动画协作执行
            // 要求 1： animator1 先执行，animator2 在 animator1 完成后立即开始
            // 要求 2： animator2 和 animator3 同时开始

            animatorSet.play(animator2).with(animator3).after(animator1)
            animatorSet.start()
        }
    }
}
