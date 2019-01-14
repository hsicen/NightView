package com.hencoder.hencoderpracticedraw3.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class Practice13GetTextBoundsView : View {
    private var paint1 = Paint(Paint.ANTI_ALIAS_FLAG)
    private var paint2 = Paint(Paint.ANTI_ALIAS_FLAG)

    val mTexts = arrayOf("A", "a", "J", "j", "Â", "â")
    val mOffsets = arrayOf(0, 0, 0, 0, 0, 0)
    val mRect = Rect()

    internal var top = 200
    internal var bottom = 400

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    init {
        paint1.style = Paint.Style.STROKE
        paint1.strokeWidth = 20f
        paint1.color = Color.parseColor("#E91E63")
        paint2.textSize = 160f

        paint2.getTextBounds(mTexts[0], 0, mTexts[0].length, mRect)
        mOffsets[0] = -(mRect.top + mRect.bottom) / 2

        paint2.getTextBounds(mTexts[1], 0, mTexts[1].length, mRect)
        mOffsets[1] = -(mRect.top + mRect.bottom) / 2

        paint2.getTextBounds(mTexts[2], 0, mTexts[2].length, mRect)
        mOffsets[2] = -(mRect.top + mRect.bottom) / 2

        paint2.getTextBounds(mTexts[3], 0, mTexts[3].length, mRect)
        mOffsets[3] = -(mRect.top + mRect.bottom) / 2

        paint2.getTextBounds(mTexts[4], 0, mTexts[4].length, mRect)
        mOffsets[4] = -(mRect.top + mRect.bottom) / 2

        paint2.getTextBounds(mTexts[5], 0, mTexts[5].length, mRect)
        mOffsets[5] = -(mRect.top + mRect.bottom) / 2
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawRect(50f, top.toFloat(), (width - 50).toFloat(), bottom.toFloat(), paint1)

        // 使用 Paint.getTextBounds() 计算出文字的显示区域
        // 然后计算出文字的绘制位置，从而让文字上下居中
        // 这种居中算法的优点是，可以让文字精准地居中，分毫不差

        val middle = (top + bottom) / 2
        canvas.drawText(mTexts[0], 100f, middle.toFloat() + mOffsets[0], paint2)
        canvas.drawText(mTexts[1], 200f, middle.toFloat() + mOffsets[1], paint2)
        canvas.drawText(mTexts[2], 300f, middle.toFloat() + mOffsets[2], paint2)
        canvas.drawText(mTexts[3], 400f, middle.toFloat() + mOffsets[3], paint2)
        canvas.drawText(mTexts[4], 500f, middle.toFloat() + mOffsets[4], paint2)
        canvas.drawText(mTexts[5], 600f, middle.toFloat() + mOffsets[5], paint2)
    }
}