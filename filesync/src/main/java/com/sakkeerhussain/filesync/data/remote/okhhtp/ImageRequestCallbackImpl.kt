package com.sakkeerhussain.filesync.data.remote.okhhtp

import android.graphics.BitmapFactory
import com.sakkeerhussain.filesync.data.request.ImageRequest
import com.sakkeerhussain.filesync.data.request.Request
import com.sakkeerhussain.filesync.ui.client.ImageTarget
import com.sakkeerhussain.filesync.ui.client.ImageViewTarget
import okhttp3.Call
import okhttp3.Response
import java.io.IOException

class ImageRequestCallbackImpl(override val request: Request) : okhttp3.Callback, RequestCallback {

    override fun onFailure(call: Call, e: IOException) {

        if (request is ImageRequest) {
            request.targets.filterIsInstance<ImageTarget>().forEach {
                val img = request.errorImageResource ?: return
                it.loadImage(img)
            }
        }
    }

    override fun onResponse(call: Call, response: Response) {

        val body = response.body
        if (body == null) {
            onFailure(call, IOException("Received null response"))
            return
        }

        val inputStream = body.byteStream()
        val bitmap = BitmapFactory.decodeStream(inputStream)
        if (bitmap == null) {
            onFailure(call, IOException("Received null image"))
            return
        }

        request.targets.filterIsInstance<ImageTarget>().forEach {
            it.loadImage(bitmap)
        }
    }
}