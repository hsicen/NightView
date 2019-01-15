package com.hencoder.hencoderpracticedraw3.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * <p>作者：Night  2019/1/15 10:18
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：measureText
 *
 * measureText
 * measure text's width with float value
 *
 * getTextWidths
 *   get every char's width of the string
 *
 * breakText
 *   get break text's width
 */
class Practice12MeasureTextView : View {
    internal var paint1 = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var paint2 = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var text1 = "三个月内你胖了"
    internal var text2 = "4.5"
    internal var text3 = "公斤"

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    init {
        paint1.textSize = 60f
        paint2.textSize = 120f
        paint2.color = Color.parseColor("#E91E63")
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 使用 Paint.measureText 测量出文字宽度，让文字可以相邻绘制

        canvas.drawText(text1, 50f, 200f, paint1)
        val width1 = paint1.measureText(text1)
        canvas.drawText(text2, (50 + width1), 200f, paint2)
        val width2 = paint2.measureText(text2)
        canvas.drawText(text3, (50 + width1 + width2), 200f, paint1)
    }
}
