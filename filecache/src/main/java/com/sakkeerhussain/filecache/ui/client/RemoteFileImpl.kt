package com.sakkeerhussain.filecache.ui.client

import com.sakkeerhussain.filecache.data.request.RequestBuilder
import com.sakkeerhussain.filecache.data.request.ImageRequestBuilderImpl
import com.sakkeerhussain.filecache.data.request.ImageRequestQueueImpl
import com.sakkeerhussain.filecache.data.request.JsonRequestBuilderImpl

class RemoteFileImpl(
    val mImageRequestQueueImpl: ImageRequestQueueImpl
): RemoteFile {

    override fun loadImage(url: String): ImageRequestBuilderImpl {
        return ImageRequestBuilderImpl(mImageRequestQueueImpl, url)
    }

    override fun loadJson(url: String): RequestBuilder {
        return JsonRequestBuilderImpl(mImageRequestQueueImpl, url)
    }
}