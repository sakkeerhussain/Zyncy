package com.sakkeerhussain.filecache.ui.request

import android.widget.ImageView
import com.sakkeerhussain.filecache.ui.client.BaseTarget
import com.sakkeerhussain.filecache.ui.client.ImageViewTarget

class ImageRequestBuilderImpl(url: String) : ImageRequestBuilder{

    override val request: Request
    override var target: BaseTarget? = null

    init {
        request = ImageRequest(url)
    }

    override fun addHeader(name: String, value: String): ImageRequestBuilderImpl {
        this.request.headers[name] = value
        return this
    }

    override fun toTarget(target: BaseTarget) {
        this.target = target

        //TODO - queue requests
    }

    override fun toTarget(target: ImageView) {
        this.toTarget(ImageViewTarget(target))
    }

}