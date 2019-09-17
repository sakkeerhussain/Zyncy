package com.sakkeer.filesync.data.request

import android.widget.ImageView
import com.sakkeer.filesync.client.BaseTarget

interface ImageRequestBuilder : RequestBuilder {

    override fun addHeader(name: String, value: String): ImageRequestBuilder
    override fun toTarget(target: BaseTarget): Request
    fun placeholder(imgResource: Int): ImageRequestBuilderImpl
    fun errorImage(imgResource: Int): ImageRequestBuilderImpl


    // Additional util functions
    fun toTarget(target: ImageView): Request
}