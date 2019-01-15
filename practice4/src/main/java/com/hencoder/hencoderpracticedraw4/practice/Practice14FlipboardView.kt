package com.hencoder.hencoderpracticedraw4.practice

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import com.hencoder.hencoderpracticedraw4.R

/**
 * <p>作者：Night  2019/1/15 16:33
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：use camera apply page function
 */
class Practice14FlipboardView : View {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap: Bitmap
    internal var camera = Camera()
    internal var degree: Int = 0
    internal var animator = ObjectAnimator.ofInt(this, "degree", 0, 180)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)

        animator.duration = 2500
        animator.interpolator = LinearInterpolator()
        animator.repeatCount = ValueAnimator.INFINITE
        animator.repeatMode = ValueAnimator.REVERSE
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        animator.start()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        animator.end()
    }

    fun setDegree(degree: Int) {
        this.degree = degree
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val bitmapWidth = bitmap.width
        val bitmapHeight = bitmap.height
        val centerX = width / 2f
        val centerY = height / 2f
        val x = centerX - bitmapWidth / 2f
        val y = centerY - bitmapHeight / 2f

        //draw upper
        canvas.save()
        canvas.clipRect(0f, 0f, width.toFloat(), centerY)
        canvas.drawBitmap(bitmap, x, y, paint)
        canvas.restore()

        //draw downer
        canvas.save()
        if (degree < 90) {
            // if the degree lower 90, then clip the bottom one
            canvas.clipRect(0f, centerY, width.toFloat(), height.toFloat())
        } else {
            //if the degree more than 90, then clip the upper one
            canvas.clipRect(0f, 0f, width.toFloat(), centerY)
        }

        camera.save()
        camera.rotateX(degree.toFloat())
        canvas.translate(centerX, centerY)
        camera.applyToCanvas(canvas)
        canvas.translate((-centerX), (-centerY))
        camera.restore()

        canvas.drawBitmap(bitmap, x, y, paint)
        canvas.restore()
    }
}
