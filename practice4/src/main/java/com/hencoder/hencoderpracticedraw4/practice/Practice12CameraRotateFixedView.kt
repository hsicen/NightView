package com.hencoder.hencoderpracticedraw4.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw4.R

class Practice12CameraRotateFixedView : View {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap: Bitmap
    internal var point1 = Point(200, 200)
    internal var point2 = Point(600, 200)

    val mCamera = Camera()
    val mMatrix = Matrix()

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
        mCamera.save()
        mMatrix.reset()
        val centerX1 = point1.x + bitmap.width / 2f
        val centerY1 = point1.y + bitmap.height / 2f

        /*mCamera.rotateX(30f)
        canvas.translate(centerX1, centerY1) //move it to center
        mCamera.applyToCanvas(canvas)
        canvas.translate(-centerX1, -centerY1) //move it back to original
        mCamera.restore()*/

        mCamera.rotateX(30f)
        mCamera.getMatrix(mMatrix)
        mCamera.restore()
        mMatrix.preTranslate(-centerX1, -centerY1) //move to original
        mMatrix.postTranslate(centerX1, centerY1) //move to center

        canvas.concat(mMatrix)
        canvas.drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
        canvas.restore()

        canvas.save()
        mCamera.save()
        val centerX2 = point2.x + bitmap.width / 2f
        val centerY2 = point2.y + bitmap.height / 2f

        mCamera.rotateY(30f)
        canvas.translate(centerX2, centerY2)
        mCamera.applyToCanvas(canvas)
        canvas.translate(-centerX2, -centerY2)
        mCamera.restore()

        canvas.drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
        canvas.restore()
    }
}
