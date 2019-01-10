package com.hencoder.hencoderpracticedraw1.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class Practice10HistogramView : View {
    var mPaint = Paint()
    var mPath = Path()
    var mTextRect = Rect()

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //        综合练习
        //        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        //绘制坐标系
        mPaint.style = Paint.Style.STROKE
        mPaint.isAntiAlias = true
        mPaint.strokeWidth = 4f
        mPaint.color = Color.WHITE
        mPath.moveTo(100f, 50f)
        mPath.lineTo(100f, 600f)
        mPath.lineTo(1000f, 600f)
        canvas.drawPath(mPath, mPaint)

        //绘制字
        val mText = "直方图"
        mPaint.textSize = 60f
        mPaint.style = Paint.Style.FILL
        mPaint.strokeWidth = 1f
        mPaint.getTextBounds(mText, 0, mText.length, mTextRect)
        canvas.drawText(mText, 500f - mTextRect.width() / 2, 750f, mPaint)

        //绘制方块  900÷7=128
        mPaint.color = Color.GREEN
        canvas.drawRect(120f, 595f, 220f, 600f, mPaint)
        canvas.drawRect(240f, 580f, 340f, 600f, mPaint)
        canvas.drawRect(360f, 580f, 460f, 600f, mPaint)
        canvas.drawRect(480f, 400f, 580f, 600f, mPaint)
        canvas.drawRect(600f, 300f, 700f, 600f, mPaint)
        canvas.drawRect(720f, 200f, 820f, 600f, mPaint)
        canvas.drawRect(840f, 400f, 940f, 600f, mPaint)

        //绘制字
        mPaint.color = Color.WHITE
        mPaint.textSize = 30f
        canvas.drawText("L", 760f, 630f, mPaint)
        canvas.drawText("KitKat", 610f, 630f, mPaint)
        canvas.drawText("JB", 510f, 630f, mPaint)
        canvas.drawText("ICS", 390f, 630f, mPaint)
        canvas.drawText("GB", 270f, 630f, mPaint)
        canvas.drawText("M", 880f, 630f, mPaint)
        canvas.drawText("Froyo", 140f, 630f, mPaint)
    }
}
