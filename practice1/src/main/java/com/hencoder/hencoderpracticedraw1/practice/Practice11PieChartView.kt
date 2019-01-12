package com.hencoder.hencoderpracticedraw1.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

/**
 * <p>作者：Night  2019/1/11 9:05
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：绘制饼图
 */
class Practice11PieChartView : View {
    var mPaint = Paint()
    private val mRectF = RectF(200f, 20f, 800f, 620f)
    private val mMaxRectF = RectF(180f, 0f, 780f, 600f)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //        综合练习
        //        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        canvas.drawColor(Color.parseColor("#506E7A"))

        mPaint.color = Color.WHITE
        mPaint.textSize = 45f
        mPaint.isAntiAlias = true
        canvas.drawText("饼图", 480f, 680f, mPaint)

        mPaint.textSize = 25f
        mPaint.strokeWidth = 2f
        canvas.drawText("Lollipop", 10f, 40f, mPaint)
        canvas.drawLines(
            floatArrayOf(
                110f, 40f, 280f, 40f, 280f, 40f,
                (480 - 300 * Math.sin(Math.toRadians(30.0))).toFloat(),
                (300 - 300 * Math.cos(Math.toRadians(30.0))).toFloat()
            ), mPaint
        )

        canvas.drawText("KitKat", 60f, 610f, mPaint)
        canvas.drawLines(
            floatArrayOf(
                150f, 605f, 320f, 605f, 320f, 605f,
                (500 - 300 * Math.sin(Math.toRadians(30.0))).toFloat(),
                (320 + 300 * Math.cos(Math.toRadians(30.0))).toFloat()
            ), mPaint
        )
        canvas.drawText("Marshmallow", 900f, 170f, mPaint)
        canvas.drawLines(
            floatArrayOf(
                (500 + 300 * Math.cos(Math.toRadians(30.0))).toFloat(),
                (320 - 300 * Math.sin(Math.toRadians(30.0))).toFloat(),
                820f, 165f, 820f, 165f, 900f, 165f
            ), mPaint
        )
        canvas.drawText("Froyo", 900f, 330f, mPaint)
        canvas.drawLines(floatArrayOf(800f, 325f, 900f, 325f), mPaint)
        canvas.drawText("Gingerbread", 900f, 370f, mPaint)
        canvas.drawLines(
            floatArrayOf(
                (500 + 300 * Math.cos(Math.toRadians(5.0))).toFloat(),
                (320 + 300 * Math.sin(Math.toRadians(5.0))).toFloat(),
                830f,
                (320 + 300 * Math.sin(Math.toRadians(5.0))).toFloat() + 10,
                830f,
                (320 + 300 * Math.sin(Math.toRadians(5.0))).toFloat() + 10,
                900f, 365f
            ), mPaint
        )
        canvas.drawText("Ice Cream Sandwich", 900f, 410f, mPaint)
        canvas.drawLines(
            floatArrayOf(
                (500 + 300 * Math.cos(Math.toRadians(12.0))).toFloat(),
                (320 + 300 * Math.sin(Math.toRadians(12.0))).toFloat(),
                830f,
                (320 + 300 * Math.sin(Math.toRadians(12.0))).toFloat() + 10,
                830f,
                (320 + 300 * Math.sin(Math.toRadians(12.0))).toFloat() + 10,
                900f, 405f
            ), mPaint
        )

        canvas.drawText("Jelly Bean", 900f, 540f, mPaint)
        canvas.drawLines(
            floatArrayOf(
                (500 + 300 * Math.cos(Math.toRadians(45.0))).toFloat(),
                (320 + 300 * Math.sin(Math.toRadians(45.0))).toFloat(),
                800f, 540f, 800f, 540f, 900f, 535f
            ), mPaint
        )

        mPaint.color = Color.YELLOW
        canvas.drawArc(mRectF, -60f, 60f, true, mPaint)
        mPaint.color = Color.parseColor("#8E24AA")
        canvas.drawArc(mRectF, 2f, 5f, true, mPaint)
        mPaint.color = Color.parseColor("#D7CCC8")
        canvas.drawArc(mRectF, 9f, 5f, true, mPaint)
        mPaint.color = Color.parseColor("#66BB6A")
        canvas.drawArc(mRectF, 16f, 60f, true, mPaint)
        mPaint.color = Color.BLUE
        canvas.drawArc(mRectF, 78f, 100f, true, mPaint)
        mPaint.color = Color.RED
        canvas.drawArc(mMaxRectF, 180f, 118f, true, mPaint)
    }
}
