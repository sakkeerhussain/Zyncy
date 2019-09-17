package com.sakkeer.filesync.data.callback

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.sakkeer.filesync.data.repository.ImageRepository
import java.io.InputStream

interface ImageResponseCallback: ResponseCallback {

    val mImageRepository: ImageRepository

    fun onResponse(data: Bitmap)

    override fun onResponse(inputStream: InputStream) {
        val bitmap = BitmapFactory.decodeStream(inputStream)
        if (bitmap == null) {
            onFailure(Exception("Received invalid image"))
        } else {
            this.onResponse(bitmap)
        }
    }
}