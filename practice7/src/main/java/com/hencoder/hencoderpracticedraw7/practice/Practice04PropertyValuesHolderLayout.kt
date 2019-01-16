package com.hencoder.hencoderpracticedraw7.practice

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Context
import android.util.AttributeSet
import android.view.animation.OvershootInterpolator
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.practice_property_values_holder.view.*

/**
 * <p>作者：Night  2019/1/16 15:16
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：he use of PropertyValueHolder
 *
 * ObjectAnimator.ofPropertyValueHolder()
 */
class Practice04PropertyValuesHolderLayout : RelativeLayout {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        animateBt.setOnClickListener {
            // 使用 PropertyValuesHolder.ofFloat() 来创建不同属性的动画值方案
            // 第一个： scaleX 从 0 到 1
            // 第二个： scaleY 从 0 到 1
            // 第三个： alpha 从 0 到 1

            // 然后，用 ObjectAnimator.ofPropertyValuesHolder() 把三个属性合并，创建 Animator 然后执行
            val holder1 = PropertyValuesHolder.ofFloat("scaleX", 0f, 1f)
            val holder2 = PropertyValuesHolder.ofFloat("scaleY", 0f, 1f)
            val holder3 = PropertyValuesHolder.ofFloat("alpha", 0f, 1f)

            val oa = ObjectAnimator.ofPropertyValuesHolder(
                objectAnimatorView,
                holder1, holder2, holder3
            )

            oa.duration = 1000
            oa.interpolator = OvershootInterpolator()
            oa.start()
        }
    }
}
