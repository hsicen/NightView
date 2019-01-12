package com.hencoder.hencoderpracticedraw1.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
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
    var mPath = Path()

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //        综合练习
        //        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        mPaint.style = Paint.Style.FILL
        mPaint.color = Color.parseColor("#cdabef")
        mPaint.isAntiAlias = true
        canvas.drawArc(200f, 100f, 750f, 650f, 185f, 130f, true, mPaint)

        mPaint.color = Color.YELLOW
        canvas.drawArc(220f, 120f, 770f, 670f, 315f, 60f, true, mPaint)

        mPaint.color = Color.RED
        canvas.drawArc(220f, 120f, 770f, 670f, 377f, 7f, true, mPaint)

        mPaint.color = Color.GRAY
        canvas.drawArc(220f, 120f, 770f, 670f, 386f, 5f, true, mPaint)

        mPaint.color = Color.GREEN
        canvas.drawArc(220f, 120f, 770f, 670f, 393f, 50f, true, mPaint)

        mPaint.color = Color.BLUE
        canvas.drawArc(220f, 120f, 770f, 670f, 445f, 100f, true, mPaint)

        //绘字
        mPaint.color = Color.WHITE
        mPaint.textSize = 30f
        canvas.drawText("Lollipop", 20f, 100f, mPaint)
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = 5f

        mPath.moveTo(120f, 100f)
        mPath.rLineTo(150f, 0f)
        mPath.rLineTo(50f, 50f)

        mPath.moveTo(750f, 320f)
        mPath.rLineTo(30f, -40f)
        mPath.rLineTo(150f, 0f)

        mPath.moveTo(750f, 490f)
        mPath.lineTo(880f, 500f)

        mPath.moveTo(730f, 520f)
        mPath.rLineTo(100f, 20f)

        mPath.moveTo(650f, 600f)

        canvas.drawPath(mPath, mPaint)

        mPaint.style = Paint.Style.FILL
        mPaint.strokeWidth = 3f
        mPaint.textSize = 40f
        canvas.drawText("饼图", 450f, 730f, mPaint)
    }
}
