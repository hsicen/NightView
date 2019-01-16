package com.hencoder.hencoderpracticedraw6.practice

import android.content.Context
import android.graphics.Outline
import android.graphics.Path
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.RelativeLayout
import com.hencoder.hencoderpracticedraw6.Utils.dpToPixel
import kotlinx.android.synthetic.main.sample_translation.view.*

/**
 * <p>作者：Night  2019/1/16 9:23
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：
 *
 * view.animate()
 *
 * ViewPropertyAnimator
 * translationX()
 * translationXBy()
 *      interceptor
 *      setListener
 *      setUpdateListener
 *      withStartAction
 *      withEndAction
 *
 *
 * ObjectAnimator
 *      addListener
 *      addUpdateListener
 *      addPauseListener
 *
 *
 *  different interceptor's differences
 *  diy your own interceptor
 *
 *  withStartAction   &  withEndAction
 *  onAnimationStart  &  onAnimationEnd
 *  onAnimationCancel
 *  onAnimationRepeat
 */
class Practice01Translation : RelativeLayout {
    var mClickCount = 0
    var mAnimationCount = 6

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        if (SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            // 给音乐图标加上合适的阴影
            imageView.outlineProvider = MusicOutlineProvider()
        }

        animateBt.setOnClickListener {
            when (mClickCount) {
                0 -> imageView.animate().translationX(500f)
                1 -> imageView.animate().translationX(0f)
                2 -> imageView.animate().translationY(500f) //translationY
                3 -> imageView.animate().translationY(0f) //back to original
                4 -> if (SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    imageView.animate().translationZ(50f)
                }
                5 -> if (SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    imageView.animate().translationZ(0f)
                }
            }

            mClickCount++
            if (mClickCount >= mAnimationCount) mClickCount = 0
        }
    }

    /*** 为音乐图标设置三角形的 Outline。*/
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    internal inner class MusicOutlineProvider : ViewOutlineProvider() {
        private var path = Path()

        init {
            path.moveTo(0f, dpToPixel(10f))
            path.lineTo(dpToPixel(7f), dpToPixel(2f))
            path.lineTo(dpToPixel(116f), dpToPixel(58f))
            path.lineTo(dpToPixel(116f), dpToPixel(70f))
            path.lineTo(dpToPixel(7f), dpToPixel(128f))
            path.lineTo(0f, dpToPixel(120f))
            path.close()
        }

        override fun getOutline(view: View, outline: Outline) {
            outline.setConvexPath(path)
        }
    }
}