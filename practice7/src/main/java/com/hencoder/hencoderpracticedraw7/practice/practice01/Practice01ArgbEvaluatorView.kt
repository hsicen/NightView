package com.hencoder.hencoderpracticedraw7.practice.practice01

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice01ArgbEvaluatorView : View {
    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var color = -0x10000
        set(value) {
            field = value
            invalidate()
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
