package com.hencoder.hencoderpracticedraw4.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw4.R

class Practice11CameraRotateView : View {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap: Bitmap
    internal var point1 = Point(200, 200)
    internal var point2 = Point(600, 200)

    internal val matrix = Matrix()
    var sPoints = FloatArray(8)
    var dPoints = FloatArray(8)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)

        sPoints = floatArrayOf(
            point1.x.toFloat(), point1.y.toFloat(),
            (point1.x + bitmap.width).toFloat(), point1.y.toFloat(),
            point1.x.toFloat(), (point1.y + bitmap.height).toFloat(),
            (point1.x + bitmap.width).toFloat(), (point1.y + bitmap.height).toFloat()
        )

        dPoints = floatArrayOf(
            point1.x.toFloat() - 10, point1.y.toFloat() + 50,
            (point1.x + bitmap.width).toFloat() + 120, point1.y.toFloat() - 90,
            point1.x.toFloat() + 20, (point1.y + bitmap.height).toFloat() + 30,
            (point1.x + bitmap.width).toFloat() + 20, (point1.y + bitmap.height).toFloat() + 60
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // set diy matrix function
        /*matrix.reset()
        matrix.setPolyToPoly(sPoints, 0, dPoints, 0, 4)

        canvas.save()
        canvas.concat(matrix)
        canvas.drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
        canvas.restore()*/


        canvas.drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
        canvas.drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
    }
}
