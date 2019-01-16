package com.hencoder.hencoderpracticedraw7.practice.practice06

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

import com.hencoder.hencoderpracticedraw7.Utils.dpToPixel

class Practice06KeyframeView : View {
    private val radius = dpToPixel(80f)
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var arcRectF = RectF()

    private var progress = 0f
        set(value) {
            field = value
            invalidate()
        }

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    init {
        paint.textSize = dpToPixel(40f)
        paint.textAlign = Paint.Align.CENTER
    }

    public override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val centerX = (width / 2).toFloat()
        val centerY = (height / 2).toFloat()

        paint.color = Color.parseColor("#E91E63")
        paint.style = Paint.Style.STROKE
        paint.strokeCap = Paint.Cap.ROUND
        paint.strokeWidth = dpToPixel(15f)
        arcRectF.set(centerX - radius, centerY - radius, centerX + radius, centerY + radius)
        canvas.drawArc(arcRectF, 135f, progress * 2.7f, false, paint)

        paint.color = Color.WHITE
        paint.style = Paint.Style.FILL
        canvas.drawText(
            progress.toInt().toString() + "%",
            centerX,
            centerY - (paint.ascent() + paint.descent()) / 2,
            paint
        )
    }
}
