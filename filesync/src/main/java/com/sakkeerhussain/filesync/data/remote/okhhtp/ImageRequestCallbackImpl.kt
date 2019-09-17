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

        response.body ?: onFailure(call, IOException("Received null response"))
        val inputStream = response.body!!.byteStream()
        val bitmap = BitmapFactory.decodeStream(inputStream)

        request.targets.filterIsInstance<ImageTarget>().forEach {
            it.loadImage(bitmap)
        }
    }
}