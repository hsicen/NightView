package com.hencoder.hencoderpracticedraw7.practice.practice02

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View

/**
 * <p>作者：Night  2019/1/16 14:36
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：
 *
 * internal property will not access get and set method
 * only private property do access get and set method
 */

class Practice02HsvEvaluatorView : View {

    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var color = -0x10000
        set(value) {
            field = value
            invalidate()
            Log.d("set2", "$value")
        }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    public override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val width = width
        val height = height

        paint.color = color
        canvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), (width / 6).toFloat(), paint)
    }
}
