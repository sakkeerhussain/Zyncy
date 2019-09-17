package com.sakkeerhussain.filecache.ui.client

import com.sakkeerhussain.filecache.data.request.ImageRequestBuilderImpl
import com.sakkeerhussain.filecache.data.request.ImageRequestQueueImpl
import com.sakkeerhussain.filecache.data.request.JsonRequestBuilderImpl
import com.sakkeerhussain.filecache.data.request.RequestBuilder

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