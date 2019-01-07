package com.hencoder.hencoderpracticedraw1.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.View

/**
 * <p>作者：Night  2019/1/7 23:06
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：draw background color
 */
class Practice1DrawColorView : View {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //draw background
        canvas.drawColor(Color.parseColor("#FFFF00"))
    }
}
