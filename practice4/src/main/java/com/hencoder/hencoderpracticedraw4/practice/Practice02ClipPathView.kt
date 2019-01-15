package com.hencoder.hencoderpracticedraw4.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw4.R

/**
 * <p>作者：Night  2019/1/15 11:21
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：range clip
 *
 * clip path：
 *      canvas.save()
 *      canvas.clipPath()
 *      canvas.draw()
 *      canvas.restore()
 */

class Practice02ClipPathView : View {
    internal var paint = Paint()
    internal var bitmap: Bitmap
    internal var point1 = Point(200, 200)
    internal var point2 = Point(600, 200)

    val path1 = Path()
    val path2 = Path()

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)

        path1.addCircle(
            (point1.x + bitmap.width / 2).toFloat(),
            (point1.y + bitmap.height / 2).toFloat(),
            150f, Path.Direction.CW
        )

        path2.fillType = Path.FillType.INVERSE_WINDING
        path2.addCircle(
            (point2.x + bitmap.width / 2).toFloat(),
            (point2.y + bitmap.height / 2).toFloat(),
            150f, Path.Direction.CW
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.save()
        canvas.clipPath(path1)
        canvas.drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
        canvas.restore()

        canvas.save()
        canvas.clipPath(path2)
        canvas.drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
        canvas.restore()
    }
}
