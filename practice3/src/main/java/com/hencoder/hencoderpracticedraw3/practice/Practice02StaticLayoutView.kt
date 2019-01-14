package com.hencoder.hencoderpracticedraw3.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View

/**
 * <p>作者：Night  2019/1/14 21:45
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：静态布局
 */
class Practice02StaticLayoutView : View {
    private var textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)
    internal var text = "Hello\nHenCoder"
    private var staticLayout: StaticLayout

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        textPaint.textSize = 60f
        staticLayout = StaticLayout(
            text, textPaint, 600,
            Layout.Alignment.ALIGN_NORMAL, 1f, 0f, true
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // 使用 StaticLayout 代替 Canvas.drawText() 来绘制文字，

        // 以绘制出带有换行的文字
        canvas.save()
        canvas.translate(50f, 40f)
        staticLayout.draw(canvas)
        canvas.restore()
    }
}
