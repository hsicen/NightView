package com.hencoder.hencoderpracticedraw4.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw4.R

/**
 * <p>作者：Night  2019/1/15 13:38
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：rotate
 *      canvas.save()
 *      canvas.rotate()
 *      canvas.restore()
 */
class Practice05RotateView : View {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap: Bitmap
    internal var point1 = Point(200, 200)
    internal var point2 = Point(600, 200)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.save()
        canvas.rotate(
            180f, (point1.x + bitmap.width / 2).toFloat(),
            (point1.y + bitmap.height / 2).toFloat()
        )
        canvas.drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
        canvas.restore()

        canvas.save()
        canvas.rotate(
            45f, (point2.x + bitmap.width / 2).toFloat(),
            (point2.y + bitmap.height / 2).toFloat()
        )
        canvas.drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
        canvas.restore()
    }
}