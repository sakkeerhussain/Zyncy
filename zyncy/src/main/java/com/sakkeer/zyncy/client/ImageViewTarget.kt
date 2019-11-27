package com.sakkeer.zyncy.client

import android.app.Activity
import android.graphics.Bitmap
import android.widget.ImageView

class ImageViewTarget(val imageView: ImageView) : ImageTarget {

    override fun loadImage(img: Int) {
        (this.imageView.context as? Activity)?.runOnUiThread {
            this.imageView.setImageResource(img)
        }
    }

    override fun loadImage(bmp: Bitmap) {
        (this.imageView.context as? Activity)?.runOnUiThread {
            this.imageView.setImageBitmap(bmp)
        }
    }

}