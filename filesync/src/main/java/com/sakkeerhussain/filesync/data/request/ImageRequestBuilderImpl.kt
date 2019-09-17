package com.sakkeerhussain.filesync.data.request

import android.widget.ImageView
import com.sakkeerhussain.filesync.client.BaseTarget
import com.sakkeerhussain.filesync.client.ImageViewTarget

class ImageRequestBuilderImpl(val mQueue: RequestQueue, override var url: String) : ImageRequestBuilder{

    override var headers: HashMap<String, String> = hashMapOf()
    private var placeHolderImageResource: Int? = null
    private var errorImageResource: Int? = null

    override fun addHeader(name: String, value: String): ImageRequestBuilderImpl {
        this.headers[name] = value
        return this
    }

    override fun placeholder(imgResource: Int): ImageRequestBuilderImpl {
        this.placeHolderImageResource = imgResource
        return this
    }

    override fun errorImage(imgResource: Int): ImageRequestBuilderImpl {
        this.errorImageResource = imgResource
        return this
    }

    override fun toTarget(target: BaseTarget) {
        val request = this.build()
        mQueue.enqueue(request, target)
    }

    override fun toTarget(target: ImageView) {
        this.toTarget(ImageViewTarget(target))
    }

    private fun build(): ImageRequest {
        val request = ImageRequest(this.url)
        request.headers = this.headers
        request.placeHolderImageResource = this.placeHolderImageResource
        request.errorImageResource = this.errorImageResource
        return request
    }

}