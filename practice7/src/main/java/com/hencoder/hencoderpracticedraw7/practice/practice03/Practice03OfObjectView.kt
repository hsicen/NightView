package com.hencoder.hencoderpracticedraw7.practice.practice03

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.util.Log
import android.view.View

import com.hencoder.hencoderpracticedraw7.Utils

/**
 * <p>作者：Night  2019/1/16 15:10
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：
 *
 * private/internal property will not access the get&set method
 *
 */
class Practice03OfObjectView : View {
    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var position = PointF()
        set(value) {
            Log.d("set3", "$value")
            field = value
            invalidate()
        }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    init {
        paint.color = Color.parseColor("#009688")
    }

    public override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val innerPaddingLeft = RADIUS * 1
        val innterPaddingRight = RADIUS * 1
        val innterPaddingTop = RADIUS * 1
        val innterPaddingBottom = RADIUS * 3
        val width = width.toFloat() - innerPaddingLeft - innterPaddingRight - RADIUS * 2
        val height = height.toFloat() - innterPaddingTop - innterPaddingBottom - RADIUS * 2

        canvas.drawCircle(
            innerPaddingLeft + RADIUS + width * position.x,
            innterPaddingTop + RADIUS + height * position.y, RADIUS, paint
        )
    }

    companion object {
        val RADIUS = Utils.dpToPixel(20f)
    }
}
