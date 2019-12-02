package com.zyncy.ui.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.zyncy.R
import com.zyncy.client.Zyncy

class RemoteImageViewImpl(context: Context, attrs: AttributeSet) :
    RemoteImageView, AppCompatImageView(context, attrs) {

    private var mUrl: String?
    private var mErrorImage: Int

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.RemoteImageView,
            0, 0
        ).apply {

            try {
                mUrl = getString(R.styleable.RemoteImageView_url)
                mErrorImage = getResourceId(R.styleable.RemoteImageView_error_image, -1)
            } finally {
                recycle()
            }
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (mUrl != null) {
            val req = Zyncy.loadImage(mUrl!!)
            if (mErrorImage != -1) req.errorImage(mErrorImage)
            req.toTarget(this)
        }
    }

    override fun setUrl(url: String) {
        this.mUrl = url
        invalidate()
        requestLayout()
    }

    override fun setErrorImage(errorImage: Int) {
        this.mErrorImage = errorImage
        invalidate()
        requestLayout()
    }
}