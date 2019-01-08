package com.hencoder.hencoderpracticedraw1.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice8DrawArcView : View {
    //paint var
    var mPaint = Paint()

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        //画弧的起始0度为3点钟，顺时针旋转
        mPaint.isAntiAlias = true
        mPaint.style = Paint.Style.FILL
        mPaint.color = Color.BLACK

        canvas.drawArc(
            200f, 100f, 800f, 500f,
            0f, 120f, true, mPaint
        )

        canvas.drawArc(
            200f, 100f, 800f, 500f,
            120f, 120f, false, mPaint
        )

        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = 8f

        canvas.drawArc(
            200f, 100f, 800f, 500f,
            240f, 120f, false, mPaint
        )
    }
}
