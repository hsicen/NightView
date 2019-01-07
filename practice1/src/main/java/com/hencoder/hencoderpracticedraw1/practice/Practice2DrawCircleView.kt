package com.hencoder.hencoderpracticedraw1.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * <p>作者：Night  2019/1/7 23:10
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：draw circle
 */
class Practice2DrawCircleView : View {
    //paint
    var mPaint = Paint()

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //        练习内容：使用 canvas.drawCircle() 方法画圆
        //        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆

        //draw fill circle
        mPaint.style = Paint.Style.FILL
        mPaint.color =  Color.BLACK
        mPaint.isAntiAlias = true
        canvas.drawCircle(300f,200f,170f,mPaint)

        //draw stroke circle
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = 5f
        canvas.drawCircle(700f,200f,160f,mPaint)

        //draw blue fill circle
        mPaint.color = Color.BLUE
        mPaint.style =  Paint.Style.FILL
        canvas.drawCircle(300f,550f,170f, mPaint)

        //draw blue stroke circle
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = 45f
        canvas.drawCircle(700f,550f,150f,mPaint)
    }
}
