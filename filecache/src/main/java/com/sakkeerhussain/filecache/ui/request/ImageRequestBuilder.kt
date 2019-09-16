package com.sakkeerhussain.filecache.ui.request

import android.widget.ImageView
import com.sakkeerhussain.filecache.ui.client.BaseTarget
import com.sakkeerhussain.filecache.ui.client.ImageViewTarget

interface ImageRequestBuilder : RequestBuilder {

    override val request: Request
    override var target: BaseTarget?

    override fun addHeader(name: String, value: String): ImageRequestBuilder

    override fun toTarget(target: BaseTarget)

    // Additional util functions
    fun toTarget(target: ImageView)

}