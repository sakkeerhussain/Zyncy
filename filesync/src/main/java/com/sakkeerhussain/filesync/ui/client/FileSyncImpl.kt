package com.sakkeerhussain.filesync.ui.client

import com.sakkeerhussain.filesync.data.request.ImageRequestBuilderImpl
import com.sakkeerhussain.filesync.data.request.ImageRequestQueueImpl
import com.sakkeerhussain.filesync.data.request.JsonRequestBuilderImpl
import com.sakkeerhussain.filesync.data.request.RequestBuilder

class FileSyncImpl(
    val mImageRequestQueueImpl: ImageRequestQueueImpl
): FileSync {

    override fun loadImage(url: String): ImageRequestBuilderImpl {
        return ImageRequestBuilderImpl(mImageRequestQueueImpl, url)
    }

    override fun loadJson(url: String): RequestBuilder {
        return JsonRequestBuilderImpl(mImageRequestQueueImpl, url)
    }
}