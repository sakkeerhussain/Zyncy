package com.sakkeerhussain.filecache.ui.client

import com.sakkeerhussain.filecache.ui.request.RequestBuilder
import com.sakkeerhussain.filecache.ui.request.ImageRequestBuilderImpl
import com.sakkeerhussain.filecache.ui.request.JsonRequestBuilderImpl

object RemoteFileImpl: RemoteFile {

    override fun loadImage(url: String): ImageRequestBuilderImpl {
        return ImageRequestBuilderImpl(url)
    }

    override fun loadJson(url: String): RequestBuilder {
        return JsonRequestBuilderImpl(url)
    }
}