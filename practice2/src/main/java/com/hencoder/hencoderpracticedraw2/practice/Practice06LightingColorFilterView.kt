package com.hencoder.hencoderpracticedraw2.practice

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

import com.hencoder.hencoderpracticedraw2.R

class Practice06LightingColorFilterView : View {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // 使用 Paint.setColorFilter() 来设置 LightingColorFilter


        // 第一个 LightingColorFilter：去掉红色部分
        val colorFilter1 = LightingColorFilter(0x00ffff, 0x000000)
        paint.colorFilter = colorFilter1
        canvas.drawBitmap(bitmap, 0f, 0f, paint)

        // 第二个 LightingColorFilter：增强绿色部分
        val colorFilter2 = LightingColorFilter(0xffffff, 0x003000)
        paint.colorFilter = colorFilter2
        canvas.drawBitmap(bitmap, (bitmap.width + 100).toFloat(), 0f, paint)
    }
}
