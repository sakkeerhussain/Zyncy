package com.sakkeerhussain.filesync.data.request

import android.widget.ImageView
import com.sakkeerhussain.filesync.ui.client.BaseTarget

interface ImageRequestBuilder : RequestBuilder {

    override fun addHeader(name: String, value: String): ImageRequestBuilder
    override fun toTarget(target: BaseTarget)
    fun placeholder(imgResource: Int): ImageRequestBuilderImpl
    fun errorImage(imgResource: Int): ImageRequestBuilderImpl


    // Additional util functions
    fun toTarget(target: ImageView)
}