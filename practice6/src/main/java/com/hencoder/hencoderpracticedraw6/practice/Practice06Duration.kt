package com.hencoder.hencoderpracticedraw6.practice

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.SeekBar
import com.hencoder.hencoderpracticedraw6.R
import com.hencoder.hencoderpracticedraw6.Utils
import kotlinx.android.synthetic.main.practice_duration.view.*

class Practice06Duration : LinearLayout {
    private var isAnimate = true
    internal var duration = 300L

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        durationValueTv.text = context.getString(R.string.ms_with_value, duration)
        durationSb.max = 10
        durationSb.progress = 1
        durationSb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                duration = progress * 300L
                durationValueTv.text = context.getString(R.string.ms_with_value, duration)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })

        animateBt.setOnClickListener {
            // 在这里处理点击事件，执行动画。记得使用 `setDuration(duration)` 来设置动画的时长。
            if (isAnimate) {
                imageView.animate()
                    .translationX(Utils.dpToPixel(170f))
                    .rotation(360f)
                    .scaleX(1f)
                    .scaleY(1f)
                    .alpha(1f)
                    .duration = duration
            } else {
                imageView.animate()
                    .translationX(0f)
                    .rotation(0f)
                    .scaleX(0f)
                    .scaleY(0f)
                    .alpha(0f)
                    .duration = duration
            }

            isAnimate = !isAnimate
        }
    }
}
