package com.hencoder.hencoderpracticedraw7.practice.practice06

import android.animation.Keyframe
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.practice_keyframe.view.*

/**
 * <p>作者：Night  2019/1/16 15:36
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：PropertyValueHolder.ofKeyFrame()
 *
 * KeyFrame.ofFloat()
 * KeyFrame.ofInt()
 * KeyFrame.ofObject()
 *
 * PropertyValueHolder.ofKeyFrame(property,frame1, frame2,......)
 *ObjectAnimator.ofPropertyValueHolder(view, holder,...)
 */
class Practice06KeyframeLayout : RelativeLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        setLayerType(View.LAYER_TYPE_SOFTWARE,null)

        animateBt.setOnClickListener {
            // 使用 Keyframe.ofFloat() 来为 view 的 progress 属性创建关键帧  objectAnimatorView
            // 初始帧：progress 为 0
            // 时间进行到一般：progress 为 100
            // 结束帧：progress 回落到 80
            // 使用 PropertyValuesHolder.ofKeyframe() 来把关键帧拼接成一个完整的属性动画方案
            // 使用 ObjectAnimator.ofPropertyValuesHolder() 来创建动画

            val frame1 = Keyframe.ofFloat(0f, 0f)
            val frame2 = Keyframe.ofFloat(0.5f, 100f)
            val frame3 = Keyframe.ofFloat(0.8f, 80f)
            val frame4 = Keyframe.ofFloat(1f, 90f)

            val valuesHolder = PropertyValuesHolder.ofKeyframe("progress", frame1, frame2, frame3, frame4)
            val animator = ObjectAnimator.ofPropertyValuesHolder(objectAnimatorView, valuesHolder)
            animator.duration = 2000
            animator.start()
        }
    }
}
