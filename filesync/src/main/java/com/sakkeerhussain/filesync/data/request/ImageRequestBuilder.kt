package com.sakkeerhussain.filesync.data.request

import android.widget.ImageView
import com.sakkeerhussain.filesync.ui.client.BaseTarget

interface ImageRequestBuilder : RequestBuilder {

    override var url: String
    override var headers: HashMap<String, String>

    override fun addHeader(name: String, value: String): ImageRequestBuilder

    override fun toTarget(target: BaseTarget)

    // Additional util functions
    fun toTarget(target: ImageView)

}