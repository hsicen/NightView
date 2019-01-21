package com.hencoder.hencoderpracticelayout1.practice

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView

/**
 * 需要把它写成正方形的 ImageView
 *
 * View和ViewGroup：测量阶段和布局阶段
 * 测量阶段：
 *      measure方法被父View调用，在measure方法中做一些准备工作和优化工作后，
 *      调用onMeasure()方法来进行实际的自我测量，onMeasure方法做的事，View和View Group不一样
 *      View：View在onMeasure()中会计算出自己的尺寸然后保存
 *      View Group：View Group在onMeasure()方法中会调用所有子View的measure方法让它们进行自我测量
 *                          并根据子View计算出的期望尺寸来计算出他们的实际尺寸和位置，然后保存。
 *                          同时，他也会根据子View的尺寸和位置来计算出自己的尺寸然后保存
 *
 * 布局阶段：
 *      layout()方法被父View调用，在layout()方法中它会保存父View传进来的自己的位置和尺寸
 *      并调用onLayout()方法来进行实际的内部布局。onLayout()方法做的事，View和ViewGroup也不一样
 *      View：由于没有子View，所以View的onLayout()什么也不做
 *      ViewGroup：ViewGroup在onLayout()中会调用自己的所有子View的layout()方法，
 *                         把他们的尺寸和位置传给他们，让它们完成自我的内部布局
 *
 *布局过程自定义的方式：
 *      方式一：重写onMeasure()来修改已有的View的尺寸
 *      方式二：重写onMeasure()来全新定制自定义View的尺寸
 *      方式三：重写onMeasure()和onLayout()来全新定制自定义ViewGroup的内部布局
 *
 * 第一类自定义的具体做法：
 *      S1：重写onMeasure()，并在里面调用super.onMeasure()，触发原有的自我测量
 *      S2：在super.onMeasure()的下面用getMeasuredWidth()和getMeasuredHeight()来获取到之前的测量结果
 *              并根据使用自己的算法，根据测量结果计算出新的结果
 *      S3：调用setMeasuredDimension()来保存新的结果
 *
 *
 * 自定义全新View尺寸：
 *      S1：重写onMeasure()，自己计算出View的尺寸
 *      S2：调用resolveSize()，纠正View的尺寸信息
 *      S3：setMeasureDimension()，设置View尺寸
 *
 *自定义ViewGroup：
 *      1. 重写onMeasure()来计算内部布局(重点)
 *      2. 重写onLayout(0来摆放子View
 *
 * 重写onMeasure()的三个步骤：
 *      1. 调用每个子View的measure()来计算子View的尺寸
 *      2. 计算子View的位置并保存子View的位置和尺寸
 *      3. 计算自己的尺寸并调用setMeasureDimension()保存
 */
class Practice01SquareImageView : ImageView {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    /**
     * 重写 onMeasure()，调整尺寸，让 ImageView 总是正方形
     */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        // 先用 getMeasuredWidth() 和 getMeasuredHeight() 取到 super.onMeasure() 的计算结果
        // 然后通过计算，让宽度和高度一致
        // 再用 setMeasuredDimension(width, height) 来保存最终的宽度和高度
        if (measuredHeight > measuredWidth) {
            setMeasuredDimension(measuredWidth, measuredWidth)
        } else {
            setMeasuredDimension(measuredHeight, measuredHeight)
        }
    }
}
