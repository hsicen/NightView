package com.hencoder.hencoderpracticedraw4.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw4.R

/**
 * <p>作者：Night  2019/1/15 14:08
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：Matrix
 *
 * pre : insert the operation at the  front of the queen
 * post：insert the operation at the rear of the queen
 * set：clear the queen, and insert the operation
 *
 *
 *matrix: create a queen to contain the operation
 */
class Practice07MatrixTranslateView : View {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap: Bitmap
    internal var point1 = Point(200, 200)
    internal var point2 = Point(600, 200)

    internal var matrix = Matrix()

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        matrix.reset()
        //matrix.postTranslate(-100f, -100f)
        matrix.preTranslate(-120f, -120f)

        canvas.save()
        canvas.concat(matrix)
        canvas.drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
        canvas.restore()

        matrix.reset()
        matrix.preTranslate(150f, 0f)

        canvas.save()
        canvas.concat(matrix)
        canvas.drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
        canvas.restore()
    }
}
