package com.night.check1.like

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Point
import android.util.AttributeSet
import android.view.View
import com.night.check1.R

/**
 * <p>作者：Night  2019/1/16 17:12
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：hen coder praise view
 *
 *
 */
class LikeView : View {
    var mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    val mStartPoint = Point(20, 20)

    private var likeSrc = R.drawable.ic_like_selected
        set(value) {
            field = value
            invalidate()
        }
    private var unLikeSrc = R.drawable.ic_like_unselected
        set(value) {
            field = value
            invalidate()
        }
    private var shiningSrc = R.drawable.ic_like_shining
        set(value) {
            field = value
            invalidate()
        }

    private var isLike = false
        set(value) {
            field = value
            invalidate()
        }

    private var likeNum = 0
        set(value) {
            field = value
            invalidate()
        }

    private var midPad = 0f
        set(value) {
            field = value
            invalidate()
        }

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyle: Int)
            : super(context, attrs, defStyle) {

        val typedArray = context.obtainStyledAttributes(
            attrs, R.styleable.LikeView,
            defStyle, 0
        )

        isLike = typedArray.getBoolean(R.styleable.LikeView_isLike, isLike)
        likeNum = typedArray.getInt(R.styleable.LikeView_likeNum, likeNum)
        midPad = typedArray.getDimension(R.styleable.LikeView_midPadding, midPad)

        likeSrc = typedArray.getResourceId(R.styleable.LikeView_likeSrc, likeSrc)
        unLikeSrc = typedArray.getResourceId(R.styleable.LikeView_likeSrc, unLikeSrc)
        shiningSrc = typedArray.getResourceId(R.styleable.LikeView_likeSrc, shiningSrc)

        typedArray.recycle()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)



    }

}