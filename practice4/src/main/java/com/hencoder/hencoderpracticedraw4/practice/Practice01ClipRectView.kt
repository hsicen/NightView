package com.hencoder.hencoderpracticedraw4.practice

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

import com.hencoder.hencoderpracticedraw4.R

/**
 * <p>作者：Night  2019/1/15 11:13
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：range clip
 *
 * clipRect:
 *      step:
 *      canvas.save()
 *      ........
 *      canvas.restore()
 */
class Practice01ClipRectView : View {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap: Bitmap

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val left = (width - bitmap.width) / 2
        val top = (height - bitmap.height) / 2

        canvas.save()
        //set clip range （left, top, right, bottom）
        canvas.clipRect(left + 50, top + 50, left + bitmap.width, top + bitmap.height - 100)
        canvas.drawBitmap(bitmap, left.toFloat(), top.toFloat(), paint)
        canvas.restore()
    }
}