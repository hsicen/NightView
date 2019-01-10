package com.hencoder.hencoderpracticedraw1.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class Practice9DrawPathView : View {
    var mPaint = Paint()
    var mPath = Path()

    init {
        mPath.addArc(200f, 200f, 400f, 400f, -225f, 225f)
        mPath.arcTo(400f, 200f, 600f, 400f, -180f, 225f, false)
        mPath.lineTo(400f, 542f)

        mPath.addCircle(600f, 600f, 100f, Path.Direction.CW)
    }

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //        练习内容：使用 canvas.drawPath() 方法画心形
        canvas.drawPath(mPath, mPaint)
    }
}
