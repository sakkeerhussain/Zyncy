package com.sakkeer.zyncy.data.callback

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.sakkeer.zyncy.data.repository.ImageRepository
import java.io.InputStream

interface ImageResponseCallback: ResponseCallback {

    val mImageRepository: ImageRepository

    fun onResponse(data: Bitmap, fromCache: Boolean)

    override fun onResponse(inputStream: InputStream, fromCache: Boolean) {
        val bitmap = BitmapFactory.decodeStream(inputStream)
        if (bitmap == null) {
            onFailure(Exception("Received invalid image"))
        } else {
            this.onResponse(bitmap, fromCache)
        }
    }
}